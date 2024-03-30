package com.baranbatur.chatapp.service;

import com.baranbatur.chatapp.dto.request.ReservationRequestDto;
import com.baranbatur.chatapp.entity.Chair;
import com.baranbatur.chatapp.entity.Reservation;
import com.baranbatur.chatapp.repository.ChairRepository;
import com.baranbatur.chatapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ChairRepository chairRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  ChairRepository chairRepository) {
        this.reservationRepository = reservationRepository;
        this.chairRepository = chairRepository;
    }


    @Override
    public Reservation createReservation(ReservationRequestDto reservationDto) {

        if (isReservationAvailable(reservationDto.getChairId(), reservationDto.getStartTime(), reservationDto.getEndTime())) {
            Chair chair = chairRepository.findById(reservationDto.getChairId()).get();
            Reservation reservation = new Reservation();
            reservation.setChair(chair);
            reservation.setStartTime(reservationDto.getStartTime());
            reservation.setEndTime(reservationDto.getEndTime());
            return this.reservationRepository.save(reservation);
        }
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return this.reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return this.reservationRepository.findById(id).orElse(null);
    }

    private boolean isReservationAvailable(Long chairId, LocalTime startTime, LocalTime endTime) {
        List<Reservation> reservations = reservationRepository.findByChairIdAndStartTimeBetweenOrEndTimeBetween(chairId, startTime, endTime, startTime, endTime);
        return reservations.isEmpty();
    }
}

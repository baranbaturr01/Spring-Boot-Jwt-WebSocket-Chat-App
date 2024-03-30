package com.baranbatur.chatapp.service;

import com.baranbatur.chatapp.dto.request.ReservationRequestDto;
import com.baranbatur.chatapp.entity.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation createReservation(ReservationRequestDto reservationDto);

    List<Reservation> getAllReservations();

    Reservation getReservationById(Long id);
}

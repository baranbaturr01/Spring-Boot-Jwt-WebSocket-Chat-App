package com.baranbatur.chatapp.repository;

import com.baranbatur.chatapp.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByChairIdAndStartTimeBetweenOrEndTimeBetween(Long chairId, LocalTime startTime, LocalTime endTime, LocalTime startTime1, LocalTime endTime1);

    List<Reservation> findByStartTimeLessThanEqualAndEndTimeGreaterThanEqual(LocalTime endTime, LocalTime startTime);
}

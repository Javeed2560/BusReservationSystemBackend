package com.javeed.services;

import java.util.List;

import com.javeed.entities.Reservation;

public interface ReservationService {

	Reservation addReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    List<Reservation> getReservationsByScheduleAndDepartureDate(Long scheduleId, String departureDate);
    List<Reservation> getReservationsByMobile(String mobile);
}

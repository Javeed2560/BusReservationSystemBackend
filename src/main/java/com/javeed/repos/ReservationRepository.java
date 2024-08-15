package com.javeed.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeed.entities.BusSchedule;
import com.javeed.entities.Customer;
import com.javeed.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Optional<List<Reservation>> findByCustomer(Customer customer);
	Optional<List<Reservation>> findByBusScheduleAndDepartureDate(BusSchedule busSchedule, String departureDate);
}

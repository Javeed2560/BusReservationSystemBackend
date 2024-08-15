package com.javeed.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeed.entities.Bus;
import com.javeed.entities.BusRoute;
import com.javeed.entities.BusSchedule;

public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long> {

	Optional<List<BusSchedule>> findByBusRoute(BusRoute busRoute);
	Boolean existsByBusAndBusRouteAndDepartureTime(Bus bus,BusRoute busRoute,String date);
}

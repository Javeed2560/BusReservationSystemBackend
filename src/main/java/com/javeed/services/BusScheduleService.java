package com.javeed.services;

import java.util.List;

import com.javeed.entities.BusSchedule;

public interface BusScheduleService {
	 BusSchedule addSchedule(BusSchedule busSchedule);
	    List<BusSchedule> getAllBusSchedules();
	    List<BusSchedule> getSchedulesByRoute(String routeName);
}

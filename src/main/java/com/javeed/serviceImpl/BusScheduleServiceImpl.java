package com.javeed.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.javeed.entities.BusRoute;
import com.javeed.entities.BusSchedule;
import com.javeed.exceptionModel.ReservationApiException;
import com.javeed.repos.BusRouteRepository;
import com.javeed.repos.BusScheduleRepository;
import com.javeed.services.BusScheduleService;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {

	 	@Autowired
	    private BusScheduleRepository busScheduleRepository;

	    @Autowired
	    private BusRouteRepository busRouteRepository;
	    @Override
	    public BusSchedule addSchedule(BusSchedule busSchedule) throws ReservationApiException{
	        final boolean exists =
	                busScheduleRepository.existsByBusAndBusRouteAndDepartureTime(
	                        busSchedule.getBus(),
	                        busSchedule.getBusRoute(),
	                        busSchedule.getDepartureTime());
	        if(exists) {
	            throw new ReservationApiException(HttpStatus.CONFLICT, "Duplicate Schedule");
	        }
	        return busScheduleRepository.save(busSchedule);
	    }

	    @Override
	    public List<BusSchedule> getAllBusSchedules() {
	        return busScheduleRepository.findAll();
	    }

	    @Override
	    public List<BusSchedule> getSchedulesByRoute(String routeName) {
	        final BusRoute busRoute = busRouteRepository.findByRouteName(routeName).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST, "Not Found"));
	        return busScheduleRepository.findByBusRoute(busRoute).orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST, "Not Found"));
	    }

}

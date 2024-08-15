package com.javeed.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeed.entities.BusRoute;
import com.javeed.repos.BusRouteRepository;
import com.javeed.services.BusRouteService;

@Service
public class BusRouteServiceImpl implements BusRouteService {

	@Autowired
	private BusRouteRepository busRouteRepository;
	
	@Override
	public BusRoute addRoute(BusRoute busRoute) {
		return busRouteRepository.save(busRoute);
	}

	@Override
	public List<BusRoute> getAllBusRoutes() {
		return busRouteRepository.findAll();
	}

	@Override
	public BusRoute getRouteByRouteName(String routeName) {
		return busRouteRepository.findByRouteName(routeName).orElseThrow();
	}

	@Override
	public BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo) {
		return busRouteRepository.findByCityFromAndCityTo(cityFrom, cityTo).orElseThrow();
	}

}

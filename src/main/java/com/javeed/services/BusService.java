package com.javeed.services;

import java.util.List;

import com.javeed.entities.Bus;

public interface BusService {
	
	Bus addBus(Bus bus);
	
	List<Bus> getAllBus();

}

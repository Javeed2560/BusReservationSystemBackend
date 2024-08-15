package com.javeed.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeed.entities.Bus;
import com.javeed.repos.BusRepository;
import com.javeed.services.BusService;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepository busRepository;
	
	@Override
	public Bus addBus(Bus bus) {
		// TODO Auto-generated method stub
		return busRepository.save(bus);
	}

	@Override
	public List<Bus> getAllBus() {
		// TODO Auto-generated method stub
		return busRepository.findAll();
	}

}

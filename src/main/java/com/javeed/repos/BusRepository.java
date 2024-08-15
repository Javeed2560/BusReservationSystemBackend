package com.javeed.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeed.entities.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {

}

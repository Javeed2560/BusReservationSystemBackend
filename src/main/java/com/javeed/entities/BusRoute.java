package com.javeed.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name= "bus_route")
public class BusRoute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long routeId;
	private String routeName;
	private String cityTo;
	private String cityFrom;
	private Double distanceInKm;
	
	
}

package com.javeed.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name= "bus_schedule")
public class BusSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleId;
	@OneToOne
	@JoinColumn(name="bus_id")
	private Bus bus;
	
	@OneToOne
	@JoinColumn(name="bus_route_id")
	private BusRoute busRoute;
	
	private String departureTime;
	private Integer ticketPrice;
	private Integer discount;
	private Integer processingFee;
	
	

}

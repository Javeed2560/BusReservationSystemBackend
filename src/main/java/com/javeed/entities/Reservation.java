package com.javeed.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="bus_reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationId;
	@OneToOne
	@JoinColumn(name= "customer_id")
	private Customer customer;
	@OneToOne
	@JoinColumn(name= "bus_schedule_id")
	private BusSchedule busSchedule;
	
	private Long timestamp;
	private String departureDate;
	private Integer totalSeatBooked;
	private String seatNumbers;
	private String reservationSatus;
	private Integer totalPrice;
	
	
}

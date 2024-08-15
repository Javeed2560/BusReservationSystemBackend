package com.javeed.exceptionModel;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data

public class ReservationApiException extends RuntimeException{

	private final HttpStatus status;
	private final String message;
	
	public ReservationApiException(HttpStatus status, String message) {
		this.status=status;
		this.message=message;
	}
}

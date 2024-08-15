package com.javeed.exceptionModel;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ReservationApiException.class)
	public ResponseEntity<ErrorDetails> handleReservationApiExceprion(
			ReservationApiException exception, WebRequest request){
		final ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(exception.getStatus().value());
		errorDetails.setDevErrorMessage(exception.getLocalizedMessage());
		errorDetails.setErrorMessage(request.getDescription(false));
		errorDetails.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
				
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorDetails> handleAccessDeniedException(
			AccessDeniedException exception,WebRequest request){
		
		final ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorMessage(exception.getLocalizedMessage());
		errorDetails.setDevErrorMessage(request.getDescription(false));
		errorDetails.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorDetails,HttpStatus.UNAUTHORIZED);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGloablException(
			Exception exception, WebRequest request){
		final ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorMessage(exception.getLocalizedMessage());
		errorDetails.setDevErrorMessage(request.getDescription(false));
		errorDetails.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorDetails,HttpStatus.UNAUTHORIZED);
		
	}
}

package com.practice.rest_starter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleGenericException(Exception ex){
		
		StudentErrorResponse response = new StudentErrorResponse();
		response.setErrorMessage(ex.getMessage());
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex){
		
		StudentErrorResponse response = new StudentErrorResponse();
		response.setErrorMessage(ex.getMessage());
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}

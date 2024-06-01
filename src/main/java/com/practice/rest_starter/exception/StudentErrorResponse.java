package com.practice.rest_starter.exception;

public class StudentErrorResponse {

	private String errorMessage;
	
	private int statusCode;
	
	private long timeStamp;
	

	public StudentErrorResponse() {
		
	}
	public StudentErrorResponse(String errorMessage, int statusCode, long timeStamp) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.timeStamp = timeStamp;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "StudentErrorResponse [errorMessage=" + errorMessage + ", statusCode=" + statusCode + ", timeStamp="
				+ timeStamp + "]";
	}
	
	
	
}

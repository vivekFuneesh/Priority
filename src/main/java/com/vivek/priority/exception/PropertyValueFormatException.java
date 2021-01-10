package com.vivek.priority.exception;

public class PropertyValueFormatException extends RuntimeException {

	private String message;
	
	public PropertyValueFormatException() {}
	
	public PropertyValueFormatException(String message) {this.message=message;}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}

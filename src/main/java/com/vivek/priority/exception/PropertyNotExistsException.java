package com.vivek.priority.exception;

public class PropertyNotExistsException extends RuntimeException{

	private String message;
	
	public PropertyNotExistsException() {}
	
	public PropertyNotExistsException(String message) {this.message=message;}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}

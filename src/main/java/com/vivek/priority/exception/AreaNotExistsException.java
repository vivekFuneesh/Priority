package com.vivek.priority.exception;

public class AreaNotExistsException extends RuntimeException {
	
	private String message;
	
	public AreaNotExistsException() {}
	
	public AreaNotExistsException(String message) {this.message=message;}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}

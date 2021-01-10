package com.vivek.priority.exception;

public class AuthenticationNotValidException extends RuntimeException {

	private String message;
	
	public AuthenticationNotValidException() {}
	
	public AuthenticationNotValidException(String message) {this.message=message;}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}

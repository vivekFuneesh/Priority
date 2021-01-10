package com.vivek.priority.exceptionhandler;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vivek.priority.exception.AreaNotExistsException;
import com.vivek.priority.exception.AuthenticationNotValidException;
import com.vivek.priority.exception.PropertyNotExistsException;
import com.vivek.priority.exception.PropertyValueFormatException;

@RestControllerAdvice
public class HandleGlitches {

	@ExceptionHandler(value= {ValidationException.class,PropertyValueFormatException.class})
	public ResponseEntity<?> getValidationException(Exception e){
		return ResponseEntity.badRequest().body(e.getLocalizedMessage());
	}
	
	@ExceptionHandler(value = { AreaNotExistsException.class,PropertyNotExistsException.class})
	public ResponseEntity<?> getAreaNotExistsException(Exception e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(AuthenticationNotValidException.class)
	public ResponseEntity<?> getAuthenticationNotValidException(AuthenticationNotValidException e){
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> getException(Exception e){
		return ResponseEntity.badRequest().body(e.getLocalizedMessage());
	}
}

package com.adyb.backendapp.auth.exceptions;

public class EmailAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistException() {
		super();		
	}

	public EmailAlreadyExistException(String message) {
		super(message);	
	}

	
}

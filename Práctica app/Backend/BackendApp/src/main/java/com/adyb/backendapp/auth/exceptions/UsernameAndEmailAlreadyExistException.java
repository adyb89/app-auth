package com.adyb.backendapp.auth.exceptions;

public class UsernameAndEmailAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsernameAndEmailAlreadyExistException() {
		super();		
	}

	public UsernameAndEmailAlreadyExistException(String message) {
		super(message);
	}
	
}

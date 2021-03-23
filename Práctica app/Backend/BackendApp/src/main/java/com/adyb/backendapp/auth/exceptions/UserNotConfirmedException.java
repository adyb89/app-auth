package com.adyb.backendapp.auth.exceptions;

public class UserNotConfirmedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserNotConfirmedException() {
		super();		
	}

	public UserNotConfirmedException(String message) {
		super(message);		
	}
	
	
}

package com.adyb.backendapp.auth.exceptions;

public class VerificationTokenExpiredException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public VerificationTokenExpiredException() {
		super();	
	}

	public VerificationTokenExpiredException(String message) {
		super(message);		
	}

	
}

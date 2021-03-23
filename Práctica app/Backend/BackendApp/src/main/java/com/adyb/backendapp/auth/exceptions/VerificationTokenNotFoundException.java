package com.adyb.backendapp.auth.exceptions;

public class VerificationTokenNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VerificationTokenNotFoundException() {
		super();
	}

	public VerificationTokenNotFoundException(String message) {
		super(message);
	}
	
	

}

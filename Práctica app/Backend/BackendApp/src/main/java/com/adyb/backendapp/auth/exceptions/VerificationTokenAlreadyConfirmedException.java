package com.adyb.backendapp.auth.exceptions;

public class VerificationTokenAlreadyConfirmedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VerificationTokenAlreadyConfirmedException() {
		super();		
	}

	public VerificationTokenAlreadyConfirmedException(String message) {
		super(message);		
	}
	
	

}

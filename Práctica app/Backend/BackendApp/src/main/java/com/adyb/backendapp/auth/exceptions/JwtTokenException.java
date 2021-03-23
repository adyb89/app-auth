package com.adyb.backendapp.auth.exceptions;

public class JwtTokenException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public JwtTokenException() {
		super();		
	}

	public JwtTokenException(String message) {
		super(message);
	}
	
	

}

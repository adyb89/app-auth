package com.adyb.backendapp.auth.exceptions;

public class MailSendingErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MailSendingErrorException() {
		super();
	}

	public MailSendingErrorException(String message) {
		super(message);
	}
	
	

}

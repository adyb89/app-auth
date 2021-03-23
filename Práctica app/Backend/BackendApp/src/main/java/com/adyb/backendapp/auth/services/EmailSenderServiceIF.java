package com.adyb.backendapp.auth.services;

import com.adyb.backendapp.auth.vos.VerificationMail;

public interface EmailSenderServiceIF {

	public void sendEmail(VerificationMail verificationMail, String token);
	
}

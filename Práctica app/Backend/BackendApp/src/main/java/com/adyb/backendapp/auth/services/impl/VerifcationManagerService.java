package com.adyb.backendapp.auth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.adyb.backendapp.auth.exceptions.VerificationTokenAlreadyConfirmedException;
import com.adyb.backendapp.auth.exceptions.VerificationTokenExpiredException;
import com.adyb.backendapp.auth.exceptions.VerificationTokenNotFoundException;
import com.adyb.backendapp.auth.model.document.UserDocument;
import com.adyb.backendapp.auth.services.EmailSenderServiceIF;
import com.adyb.backendapp.auth.services.VerifcationManagerServiceIF;
import com.adyb.backendapp.auth.services.VerificationUserServiceIF;
import com.adyb.backendapp.auth.vos.VerificationMail;

@Service
public class VerifcationManagerService implements VerifcationManagerServiceIF {

	@Autowired
	private VerificationUserServiceIF verificationUserService;
	
	@Autowired
	private EmailSenderServiceIF emailSenderService;
	
	@Override
	public void startVerification(UserDocument user) {
		
		String token = verificationUserService.generateVerificationToken(user);
		if(token != null) {
			VerificationMail vm = new VerificationMail(user.getName(), token, user.getEmail());
			emailSenderService.sendEmail(vm, token);
		}			
		
	}

	@Override
	public void activateUser(String token) {		
		
		try {
			verificationUserService.verifyUser(token);		
		} catch (VerificationTokenNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		} catch (VerificationTokenAlreadyConfirmedException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		} catch (VerificationTokenExpiredException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}

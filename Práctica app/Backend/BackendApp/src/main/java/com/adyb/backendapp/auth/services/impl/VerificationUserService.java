package com.adyb.backendapp.auth.services.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adyb.backendapp.auth.exceptions.VerificationTokenAlreadyConfirmedException;
import com.adyb.backendapp.auth.exceptions.VerificationTokenExpiredException;
import com.adyb.backendapp.auth.exceptions.VerificationTokenNotFoundException;
import com.adyb.backendapp.auth.exceptions.constants.MessagesExceptionConstants;
import com.adyb.backendapp.auth.model.document.UserDocument;
import com.adyb.backendapp.auth.model.document.VerificationTokenDocument;

import com.adyb.backendapp.auth.services.UserDAOServiceIF;
import com.adyb.backendapp.auth.services.VerificationUserServiceIF;
import com.adyb.backendapp.auth.services.VerificationTokenDAOServiceIF;

@Service
public class VerificationUserService implements VerificationUserServiceIF {

	@Autowired
	private VerificationTokenDAOServiceIF verificationTokenDAOService;
	
	@Autowired
	private UserDAOServiceIF userDAOService;
	
	@Override
	public String generateVerificationToken(UserDocument user) {
		
		if(user != null) {
			String token = UUID.randomUUID().toString();
			VerificationTokenDocument verificationToken =
					new VerificationTokenDocument(token, 
												  LocalDateTime.now(),
												  LocalDateTime.now()
												  	.plusMinutes(15), 
												  user.getUsername());
			
			verificationTokenDAOService.addVerificationToken(verificationToken);
			return token;
		}
		
		return null;
	}

	@Override
	public Boolean verifyUser(String token) {
		
		if(token != null && !token.isEmpty()) {
			VerificationTokenDocument vt =
					verificationTokenDAOService.getTokenByToken(token)
					.orElseThrow(() -> new VerificationTokenNotFoundException(MessagesExceptionConstants.VERIFICATION_TOKEN_NOT_FOUND));					
			
			if(vt.getConfirmedAt() != null) {
				throw new VerificationTokenAlreadyConfirmedException(MessagesExceptionConstants.VERIFICATION_TOKEN_ALREADY_CONFIRMED);
			}
			
			if(vt.isExpired()) {
				throw new VerificationTokenExpiredException(MessagesExceptionConstants.VERIFICATION_TOKEN_EXPIRED);				
			}					
			
			UserDocument user = userDAOService.getUserDocumentByUsername(vt.getUsername());
			user.setIsActived(true);
			vt.setConfirmedAt(LocalDateTime.now());
			verificationTokenDAOService.addVerificationToken(vt);
			userDAOService.addUser(user);
			return true;
		}
		
		return false;
	}

}

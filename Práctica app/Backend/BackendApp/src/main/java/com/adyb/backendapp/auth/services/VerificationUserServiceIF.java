package com.adyb.backendapp.auth.services;

import com.adyb.backendapp.auth.model.document.UserDocument;

public interface VerificationUserServiceIF {

	public String generateVerificationToken(UserDocument user);
	
	public Boolean verifyUser(String token);
}

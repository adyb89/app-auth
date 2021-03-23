package com.adyb.backendapp.auth.services;

import com.adyb.backendapp.auth.model.document.UserDocument;

public interface VerifcationManagerServiceIF {

	public void startVerification(UserDocument user);
	
	public void activateUser(String token);
}

package com.adyb.backendapp.auth.services;

import java.util.Optional;

import com.adyb.backendapp.auth.model.document.VerificationTokenDocument;

public interface VerificationTokenDAOServiceIF {

	public Optional<VerificationTokenDocument> getTokenById(long id);	
	
	public Optional<VerificationTokenDocument> getTokenByToken(String token);
	
	public VerificationTokenDocument addVerificationToken(VerificationTokenDocument verificationToken);
}

package com.adyb.backendapp.auth.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adyb.backendapp.auth.model.document.VerificationTokenDocument;
import com.adyb.backendapp.auth.repository.VerificationTokenRepository;
import com.adyb.backendapp.auth.services.VerificationTokenDAOServiceIF;

@Service
public class VerificationTokenDAOService implements VerificationTokenDAOServiceIF {

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	
	@Override
	public Optional<VerificationTokenDocument> getTokenById(long id) {		
		return verificationTokenRepository.findById(id);
	}

	@Override
	public Optional<VerificationTokenDocument> getTokenByToken(String token) {		
		return verificationTokenRepository.findVerificationTokenDocumentByToken(token);
	}

	@Override
	public VerificationTokenDocument addVerificationToken(VerificationTokenDocument verificationToken) {		
		return verificationTokenRepository.insert(verificationToken);
	}

}

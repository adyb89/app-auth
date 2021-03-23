package com.adyb.backendapp.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.adyb.backendapp.auth.model.document.VerificationTokenDocument;

public interface VerificationTokenRepository extends MongoRepository<VerificationTokenDocument, Long> {

	Optional<VerificationTokenDocument> findVerificationTokenDocumentByToken(String token);
}

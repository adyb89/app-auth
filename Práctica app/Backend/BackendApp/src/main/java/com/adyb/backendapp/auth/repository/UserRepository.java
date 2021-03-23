package com.adyb.backendapp.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.adyb.backendapp.auth.model.document.UserDocument;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, String> {

	Optional<UserDocument> findUserDocumentByUsername(String username);
	
	Optional<UserDocument> findUserDocumentByUsernameAndPassword(String username, String password);
	
	Optional<UserDocument> findUserDocumentByEmail(String email);
	
}

package com.adyb.backendapp.auth.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.adyb.backendapp.auth.exceptions.EmailAlreadyExistException;
import com.adyb.backendapp.auth.exceptions.UserNotFoundException;
import com.adyb.backendapp.auth.exceptions.UsernameAlreadyExistException;
import com.adyb.backendapp.auth.exceptions.UsernameAndEmailAlreadyExistException;
import com.adyb.backendapp.auth.model.document.UserDocument;

public interface UserDAOServiceIF extends UserDetailsService {

	public Boolean isNotExistUserByUsername(String username) throws UsernameAlreadyExistException;
	
	public UserDocument getUserDocumentByUsername(String username) throws UserNotFoundException;	
	
	public Boolean isNotExistUserByEmail(String email) throws EmailAlreadyExistException;
	
	public UserDocument addUser(UserDocument user) throws UsernameAlreadyExistException, EmailAlreadyExistException, 
																							UsernameAndEmailAlreadyExistException;

}

package com.adyb.backendapp.auth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adyb.backendapp.auth.exceptions.EmailAlreadyExistException;
import com.adyb.backendapp.auth.exceptions.UserNotFoundException;
import com.adyb.backendapp.auth.exceptions.UsernameAlreadyExistException;
import com.adyb.backendapp.auth.exceptions.UsernameAndEmailAlreadyExistException;
import com.adyb.backendapp.auth.exceptions.constants.MessagesExceptionConstants;
import com.adyb.backendapp.auth.model.document.UserDocument;
import com.adyb.backendapp.auth.repository.UserRepository;
import com.adyb.backendapp.auth.services.UserDAOServiceIF;
import com.adyb.backendapp.auth.vos.UserPrincipal;

@Service
public class UserDAOService implements UserDAOServiceIF {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		UserDocument user = userRepository
					.findUserDocumentByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException(MessagesExceptionConstants.USERNAME_NOT_EXIST + username));
		
		return UserPrincipal.buildUser(user);
	}
	
	@Override
	public Boolean isNotExistUserByUsername(String username) throws UsernameAlreadyExistException {
		
		if(userRepository.findUserDocumentByUsername(username).isPresent()) {			
			throw new UsernameAlreadyExistException(MessagesExceptionConstants.USERNAME_ALREADY_EXIST); 
		}
		return true;
	}

	@Override
	public Boolean isNotExistUserByEmail(String email) throws EmailAlreadyExistException {

		if(userRepository.findUserDocumentByEmail(email).isPresent()) {
			throw new EmailAlreadyExistException(MessagesExceptionConstants.EMAIL_ALREADY_EXIST); 
		}
		return true;
	}

	@Override
	public UserDocument addUser(UserDocument user) throws UsernameAlreadyExistException,
															 EmailAlreadyExistException, 
															 UsernameAndEmailAlreadyExistException {
		
		if(user != null) {
			try {
				 isNotExistUserByUsername(user.getUsername());
			} catch (UsernameAlreadyExistException e) {
				try {
					isNotExistUserByEmail(user.getEmail());
				} catch (EmailAlreadyExistException e2) {
					throw new UsernameAndEmailAlreadyExistException(MessagesExceptionConstants.EMAIL_AND_USERNAME_ALREADY_EXIST);
				  }
			  }
			
			isNotExistUserByEmail(user.getEmail());
			isNotExistUserByUsername(user.getUsername());
			
			return userRepository.save(user);
		}
		
		return null;
	}

	@Override
	public UserDocument getUserDocumentByUsername(String username) throws UserNotFoundException {		
		return userRepository.findUserDocumentByUsername(username)
				.orElseThrow(() -> new UserNotFoundException(MessagesExceptionConstants.USERNAME_NOT_EXIST + username));
	}

}

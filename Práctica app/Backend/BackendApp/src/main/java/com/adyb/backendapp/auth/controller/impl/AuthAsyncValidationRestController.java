package com.adyb.backendapp.auth.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.adyb.backendapp.auth.constants.ApiUriAuth;
import com.adyb.backendapp.auth.controller.AuthAsyncValidationRestControllerIF;
import com.adyb.backendapp.auth.exceptions.constants.MessagesExceptionConstants;
import com.adyb.backendapp.auth.services.UserDAOServiceIF;
import com.adyb.backendapp.constants.CommonConstants;

@CrossOrigin(CommonConstants.URI_FRONTEND)
@RestController
public class AuthAsyncValidationRestController implements AuthAsyncValidationRestControllerIF {

	@Autowired
	private UserDAOServiceIF userDAOService;
	
	@Override
	@Async
	public ResponseEntity<Boolean> validEmail(@PathVariable(ApiUriAuth.EMAIL) String email) {
		
		if(!userDAOService.isNotExistUserByEmail(email)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MessagesExceptionConstants.EMAIL_ALREADY_EXIST);
		}
		return ResponseEntity.ok(true);
	}

	@Override
	@Async
	public ResponseEntity<Boolean> validUsername(@PathVariable(ApiUriAuth.USERNAME) String username) {
		
		if(!userDAOService.isNotExistUserByUsername(username)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MessagesExceptionConstants.USERNAME_ALREADY_EXIST);
		}
		return ResponseEntity.ok(true);
	}

}

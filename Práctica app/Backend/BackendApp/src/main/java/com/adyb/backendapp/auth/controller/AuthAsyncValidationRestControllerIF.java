package com.adyb.backendapp.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adyb.backendapp.auth.constants.ApiUriAuth;

@RequestMapping(ApiUriAuth.API_AUTH_VALIDATION)
public interface AuthAsyncValidationRestControllerIF {

	@GetMapping(ApiUriAuth.API_AUTH_VALIDATION_EMAIL)
	public ResponseEntity<Boolean> validEmail(String email);

	@GetMapping(ApiUriAuth.API_AUTH_VALIDATION_USERNAME)
	public ResponseEntity<Boolean> validUsername(String username);
}

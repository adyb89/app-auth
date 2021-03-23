package com.adyb.backendapp.auth.controller.impl;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adyb.backendapp.auth.constants.ApiUriAuth;
import com.adyb.backendapp.auth.controller.AuthRestControllerIF;
import com.adyb.backendapp.auth.model.dtos.JwtTokenDTO;
import com.adyb.backendapp.auth.model.dtos.UserLoginDTO;
import com.adyb.backendapp.auth.model.dtos.UserRegisterDTO;
import com.adyb.backendapp.auth.services.AuthManagerServiceIF;
import com.adyb.backendapp.constants.CommonConstants;

@CrossOrigin(CommonConstants.URI_FRONTEND)
@RestController
public class AuthRestController implements AuthRestControllerIF {

	@Autowired
	private AuthManagerServiceIF authManagerService;
	
	@Override
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterDTO newUser, BindingResult result) {		
		authManagerService.registerUser(newUser, result);
		return ResponseEntity.created(URI.create(ApiUriAuth.REGISTER)).build();
	}

	@Override
	public ResponseEntity<JwtTokenDTO> login(@Valid @RequestBody UserLoginDTO User, BindingResult result) {
		return ResponseEntity.ok(authManagerService.login(User, result));
	}

	@Override
	public ResponseEntity<JwtTokenDTO> refreshToken(@RequestBody JwtTokenDTO jwt) {
		return ResponseEntity.ok(authManagerService.refreshToken(jwt));
	}

	@Override
	public ResponseEntity<Boolean> confirmUser(@RequestParam(value = ApiUriAuth.TOKEN, required = true) String token) {
		return ResponseEntity.ok(authManagerService.confirmUser(token));
	}

}

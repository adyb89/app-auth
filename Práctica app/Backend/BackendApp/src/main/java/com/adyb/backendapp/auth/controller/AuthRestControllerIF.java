package com.adyb.backendapp.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adyb.backendapp.auth.constants.ApiUriAuth;
import com.adyb.backendapp.auth.model.dtos.JwtTokenDTO;
import com.adyb.backendapp.auth.model.dtos.UserLoginDTO;
import com.adyb.backendapp.auth.model.dtos.UserRegisterDTO;

@RequestMapping(ApiUriAuth.API_AUTH)
public interface AuthRestControllerIF {

	@PostMapping(ApiUriAuth.REGISTER)
	public ResponseEntity<?> registerUser(UserRegisterDTO newUser, BindingResult result);
	
	@PostMapping(ApiUriAuth.LOGIN)
	public ResponseEntity<JwtTokenDTO> login(UserLoginDTO User, BindingResult result);
	
	@PostMapping(ApiUriAuth.REFRESH)
	public ResponseEntity<JwtTokenDTO> refreshToken(JwtTokenDTO jwt);
	
	@PostMapping(ApiUriAuth.CONFIRM)
	public ResponseEntity<Boolean> confirmUser(String token);
	
}

package com.adyb.backendapp.auth.services;

import org.springframework.validation.BindingResult;

import com.adyb.backendapp.auth.model.dtos.JwtTokenDTO;
import com.adyb.backendapp.auth.model.dtos.UserLoginDTO;
import com.adyb.backendapp.auth.model.dtos.UserRegisterDTO;

public interface AuthManagerServiceIF {

	public void registerUser(UserRegisterDTO newUser, BindingResult result);
	
	public JwtTokenDTO login(UserLoginDTO User, BindingResult result);
	
	public JwtTokenDTO refreshToken(JwtTokenDTO jwt);
	
	public Boolean confirmUser(String token);
}

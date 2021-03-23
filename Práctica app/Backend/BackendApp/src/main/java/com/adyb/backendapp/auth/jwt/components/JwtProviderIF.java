package com.adyb.backendapp.auth.jwt.components;

import org.springframework.security.core.Authentication;

public interface JwtProviderIF {

	public String generateToken(Authentication auth);
	
	public String getUsernameFromToken(String token);
	
	public Boolean validateToken(String token);
	
	public String refreshToken(String token);
}

package com.adyb.backendapp.auth.jwt.constant;

public interface JwtConstants {

	public static final String UNAUTHORIZED = "Unauthorized";
	
	public static final String SECRET = "${jwt.secret}";
	
	public static final String EXPIRATION_TOKEN = "${jwt.expiration}";
	
	public static final String AUTHORIZATION = "Authorization";
	
	public static final String BEARER = "Bearer ";
}

package com.adyb.backendapp.auth.constants;

public interface ApiUriAuth {
	
	public static final String API_AUTH = "/api/auth";
	
	public static final String API_AUTH_VALIDATION = "/api/auth/validation";
	
	public static final String API_AUTH_VALIDATION_USERNAME = "/username/{username}";
	
	public static final String API_AUTH_VALIDATION_EMAIL = "/email/{email}";	
	
	public static final String REGISTER = "/register";
	
	public static final String LOGIN = "/login";
	
	public static final String REFRESH = "/refresh";
	
	public static final String CONFIRM = "/confirm";
	
	public static final String AUTH = "/api/auth/**";
	
	public static final String EMAIL = "email";
	
	public static final String USERNAME = "username";
	
	public static final String TOKEN = "token";

}

package com.adyb.backendapp.auth.exceptions.constants;

public interface MessagesExceptionConstants {

	public static final String USERNAME_NOT_EXIST = "No such user with the username: ";
	
	public static final String USERNAME_ALREADY_EXIST = "The username already exist";
	
	public static final String USER_NOT_FOUND = "Bad credential";
	
	public static final String EMAIL_ALREADY_EXIST = "The email already exist";
	
	public static final String EMAIL_AND_USERNAME_ALREADY_EXIST = "The email and username already exist";
	
	public static final String VERIFICATION_TOKEN_NOT_FOUND = "The verification token doesn't exist";
	
	public static final String VERIFICATION_TOKEN_ALREADY_CONFIRMED = "The verification token is already confirmed";
	
	public static final String VERIFICATION_TOKEN_EXPIRED = "Expired verification token";
	
	public static final String USER_NOT_CONFIRMED = "User not confirmed";
}

package com.adyb.backendapp.auth.constants;

public interface EmailConstants {
	
	public static final String SUBJECT = "Confirma tu cuenta";
	
	public static final String HOST = "${spring.mail.host}";
	
	public static final String PORT = "${spring.mail.port}";
	
	public static final String USERNAME = "${spring.mail.username}";
	
	public static final String PASSWORD = "${spring.mail.password}";
}

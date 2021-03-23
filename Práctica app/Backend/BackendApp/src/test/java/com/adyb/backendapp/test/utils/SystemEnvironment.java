package com.adyb.backendapp.test.utils;

public class SystemEnvironment {
	
	public static void setEnv() {
		
		System.setProperty("SERVER_PORT", "8080");
		System.setProperty("MONGODB_HOST", "localhost");
		System.setProperty("MONGODB_PORT", "27017");
		System.setProperty("MONGODB_DATABASE", "app");
		System.setProperty("JWT_SECRET", "q9odraE6IHNureqp9i8tr556d");
		System.setProperty("JWT_EXPIRATION_TOKEN", "3600");
	}

}

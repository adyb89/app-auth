package com.adyb.backendapp.auth.beans;

import org.springframework.beans.factory.annotation.Value;

import com.adyb.backendapp.auth.constants.EmailConstants;

import lombok.Data;

@Data
public class EmailProperties {

	@Value(EmailConstants.HOST)
	private String host;
	
	@Value(EmailConstants.PORT)
	private Integer port;
	
	@Value(EmailConstants.USERNAME)
	private String username;
	
	@Value(EmailConstants.PASSWORD)
	private String password;
}

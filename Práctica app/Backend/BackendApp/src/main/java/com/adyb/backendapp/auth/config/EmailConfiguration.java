package com.adyb.backendapp.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.adyb.backendapp.auth.beans.EmailProperties;

@Configuration
public class EmailConfiguration {

	@Bean
	public EmailProperties emailProperties() {
		return new EmailProperties();
	}
	
	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		
		mailSenderImpl.setHost(emailProperties().getHost());
		mailSenderImpl.setPort(emailProperties().getPort());
		mailSenderImpl.setUsername(emailProperties().getUsername());
		mailSenderImpl.setPassword(emailProperties().getPassword());
		
		return mailSenderImpl;
	}
}

package com.adyb.backendapp.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.adyb.backendapp.auth.jwt.components.JwtTokenFilterIF;
import com.adyb.backendapp.auth.jwt.components.impl.JwtTokenFilter;

@Configuration
public class AuthConfiguration {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JwtTokenFilterIF jwtTokenFilter() {
		return new JwtTokenFilter();
	}
}

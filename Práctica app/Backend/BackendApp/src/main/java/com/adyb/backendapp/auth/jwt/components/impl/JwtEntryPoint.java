package com.adyb.backendapp.auth.jwt.components.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.adyb.backendapp.auth.jwt.components.JwtEntryPointIF;
import com.adyb.backendapp.auth.jwt.constant.JwtConstants;

@Component
public class JwtEntryPoint implements JwtEntryPointIF {

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException authException) throws IOException, ServletException {
		
		res.sendError(HttpServletResponse.SC_UNAUTHORIZED, JwtConstants.UNAUTHORIZED);
	}

}

package com.adyb.backendapp.auth.jwt.components.impl;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.server.ResponseStatusException;

import com.adyb.backendapp.auth.jwt.components.JwtProviderIF;
import com.adyb.backendapp.auth.jwt.components.JwtTokenFilterIF;
import com.adyb.backendapp.auth.jwt.constant.JwtConstants;
import com.adyb.backendapp.auth.services.impl.UserDetailsServiceImpl;

public class JwtTokenFilter extends JwtTokenFilterIF {

	@Autowired
	private JwtProviderIF jwtProvider;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			String token = extractTokenFromRequest(req);
			
			if(token != null && token != "" && jwtProvider.validateToken(token)) {				
				UserDetails user = userDetailsService.loadUserByUsername(jwtProvider.getUsernameFromToken(token));
				UsernamePasswordAuthenticationToken auth =
						new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
				
		filterChain.doFilter(req, res);
	}

	private String extractTokenFromRequest(HttpServletRequest req) {
		String header = req.getHeader(JwtConstants.AUTHORIZATION);
		
		if(header != null && header != "" && header.startsWith(JwtConstants.BEARER)) {
			return header.replace(JwtConstants.BEARER, "");
		}
		
		return null;
	}
}

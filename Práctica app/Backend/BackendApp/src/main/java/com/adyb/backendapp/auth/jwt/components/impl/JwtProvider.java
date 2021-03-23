package com.adyb.backendapp.auth.jwt.components.impl;

import java.time.ZonedDateTime;
import java.util.Date;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.adyb.backendapp.auth.exceptions.JwtTokenException;
import com.adyb.backendapp.auth.jwt.components.JwtProviderIF;
import com.adyb.backendapp.auth.jwt.constant.JwtConstants;
import com.adyb.backendapp.auth.vos.UserPrincipal;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider implements JwtProviderIF {

	@Value(JwtConstants.SECRET)
	private String secret;
	
	@Value(JwtConstants.EXPIRATION_TOKEN)
	private int expirationToken;
	
	@Override
	public String generateToken(Authentication auth) {
		UserPrincipal user = (UserPrincipal) auth.getPrincipal();
		return generateTokenFromUsername(user.getUsername());
	}

	@Override
	public String getUsernameFromToken(String token) {
		return Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}

	@Override
	public Boolean validateToken(String token) {
		
		try {
			Jwts.parser()
			.setSigningKey(secret)
			.parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException e) {
			throw new JwtTokenException(e.getMessage());
		} catch (UnsupportedJwtException e) {
			throw new JwtTokenException(e.getMessage());
		} catch (ExpiredJwtException e) {
			throw new JwtTokenException(e.getMessage());
		} catch (SignatureException e) {
			throw new JwtTokenException(e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new JwtTokenException(e.getMessage());
		}
				
	}

	@Override
	public String refreshToken(String token) {
		String username = getUsernameFromToken(token);		
		return generateTokenFromUsername(username);
	}

	private String generateTokenFromUsername(String username) {
		return Jwts.builder().setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(Date.from(ZonedDateTime.now().plusMinutes(expirationToken*100).toInstant()))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
}

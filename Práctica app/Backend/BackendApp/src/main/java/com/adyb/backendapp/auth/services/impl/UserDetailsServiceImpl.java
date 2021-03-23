package com.adyb.backendapp.auth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adyb.backendapp.auth.services.UserDAOServiceIF;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAOServiceIF userDAOService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDAOService.loadUserByUsername(username);
	}

}

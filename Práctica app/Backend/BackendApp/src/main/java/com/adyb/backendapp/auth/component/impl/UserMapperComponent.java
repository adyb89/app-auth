package com.adyb.backendapp.auth.component.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.adyb.backendapp.auth.component.UserMapperComponentIF;
import com.adyb.backendapp.auth.model.document.UserDocument;
import com.adyb.backendapp.auth.model.dtos.UserRegisterDTO;
import com.adyb.backendapp.auth.model.enums.Role;

@Component
public class UserMapperComponent implements UserMapperComponentIF {

	@Override
	public UserDocument fromDTOtoDocument(UserRegisterDTO dto) {
		UserDocument doc = null;
		
		if(dto != null) {
			Set<Role> roles = new HashSet<>();
			roles.add(Role.USER);
			doc = new UserDocument(dto.getUsername(), dto.getName(), dto.getFamilyName(), dto.getEmail(), dto.getPassword(), false, roles);
		}
		
		return doc;
	}

	

}

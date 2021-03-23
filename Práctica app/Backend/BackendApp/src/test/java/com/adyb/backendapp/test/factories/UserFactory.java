package com.adyb.backendapp.test.factories;

import java.util.HashSet;
import java.util.Set;

import com.adyb.backendapp.auth.model.document.UserDocument;
import com.adyb.backendapp.auth.model.dtos.UserRegisterDTO;
import com.adyb.backendapp.auth.model.enums.Role;

public class UserFactory {

	public static UserRegisterDTO generateUserRegisterDTO() {		
		return new UserRegisterDTO("admin", "Adnan", "El Yaagoubi", "adnan@hotmail.com", "12345");
	}
	
	public static UserDocument generateUserDocument() {
		Set<Role> roles = new HashSet<>();
		roles.add(Role.USER);
		UserDocument doc = new UserDocument("admin", "Adnan", "El Yaagoubi", "adnan@hotmail.com", "12345", false, roles);
		
		return doc;
	}
}

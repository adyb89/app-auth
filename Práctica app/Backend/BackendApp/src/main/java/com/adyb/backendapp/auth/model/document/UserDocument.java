package com.adyb.backendapp.auth.model.document;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.adyb.backendapp.auth.model.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDocument implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String username;
	
	private String name;
	
	private String familyName;
		
	private String email;
	
	private String password;
	
	private Boolean isActived; 
	
	private Set<Role> roles;


	
}

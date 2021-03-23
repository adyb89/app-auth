package com.adyb.backendapp.auth.model.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "the username field can not be null")
	@NotEmpty(message = "the username field can not be empty")
	private String username;
	
	@NotNull(message = "the name field can not be null")
	@NotEmpty(message = "the name field can not be empty")
	private String name;
	
	@NotNull(message = "the family name field can not be null")
	@NotEmpty(message = "the family name field can not be empty")
	private String familyName;
	
	@NotNull(message = "the email field can not be null")
	@NotEmpty(message = "the email field can not be empty")
	@Email
	private String email;
	
	@NotNull(message = "the password field can not be null")
	@NotEmpty(message = "the password field can not be empty")
	private String password;
	

}

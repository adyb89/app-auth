package com.adyb.backendapp.auth.model.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtTokenDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "the token field can not be null")
	@NotEmpty(message = "the token can not be empty")
	private String token;

}

package com.adyb.backendapp.auth.vos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VerificationMail {

	private String name;
	
	private String subject;
	
	private String recipient;
	
}

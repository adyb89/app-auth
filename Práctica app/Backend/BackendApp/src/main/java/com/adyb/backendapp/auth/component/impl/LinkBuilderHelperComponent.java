package com.adyb.backendapp.auth.component.impl;

import org.springframework.stereotype.Component;

import com.adyb.backendapp.auth.component.LinkBuilderHelperComponentIF;
import com.adyb.backendapp.auth.constants.ApiUriAuth;
import com.adyb.backendapp.constants.CommonConstants;

@Component
public class LinkBuilderHelperComponent implements LinkBuilderHelperComponentIF {

	@Override
	public String buildVerificationLink(String token) {
		
		return String.format("%s%s%s?%s=%s",
				CommonConstants.URI_BASE,
				ApiUriAuth.API_AUTH,
				ApiUriAuth.CONFIRM, 
				ApiUriAuth.TOKEN, 
				token);
	}

}

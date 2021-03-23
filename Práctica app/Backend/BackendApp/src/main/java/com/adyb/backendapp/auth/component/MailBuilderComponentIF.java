package com.adyb.backendapp.auth.component;

import com.adyb.backendapp.auth.vos.VerificationMail;

public interface MailBuilderComponentIF {

	public String buildMail(VerificationMail verifcationMail, String token);
}

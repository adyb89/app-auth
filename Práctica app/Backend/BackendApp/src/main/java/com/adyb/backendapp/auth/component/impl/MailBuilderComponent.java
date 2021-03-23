package com.adyb.backendapp.auth.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.adyb.backendapp.auth.component.LinkBuilderHelperComponentIF;
import com.adyb.backendapp.auth.component.MailBuilderComponentIF;
import com.adyb.backendapp.auth.vos.VerificationMail;

@Component
public class MailBuilderComponent implements MailBuilderComponentIF {

	@Autowired
	private LinkBuilderHelperComponentIF linkBuilderHelper;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Override
	public String buildMail(VerificationMail verifcationMail, String token) {
		String link = linkBuilderHelper.buildVerificationLink(token);
		Context context = new Context();
		
		context.setVariable("link", link);
		context.setVariable("name", verifcationMail.getName());
		
		return templateEngine.process("mailTemplate", context);
	}

}

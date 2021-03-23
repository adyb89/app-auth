package com.adyb.backendapp.auth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.adyb.backendapp.auth.component.MailBuilderComponentIF;
import com.adyb.backendapp.auth.exceptions.MailSendingErrorException;
import com.adyb.backendapp.auth.services.EmailSenderServiceIF;
import com.adyb.backendapp.auth.vos.VerificationMail;

@Service
public class EmailSenderService implements EmailSenderServiceIF {

	@Autowired
	private MailBuilderComponentIF mailBuilderComponent;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	@Async
	public void sendEmail(VerificationMail verificationMail, String token) {		
		try {
			mailSender.send(buildPreparator(verificationMail, token));
		} catch (MailException e) {
			throw new MailSendingErrorException(e.getMessage());
		}
	}

	private MimeMessagePreparator buildPreparator(VerificationMail verificationMail, String token) {
		String from = "adyb@main.com";
		return mimeMessage -> {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setFrom(from);
			helper.setTo(verificationMail.getRecipient());
			helper.setSubject(verificationMail.getSubject());
			helper.setText(mailBuilderComponent.buildMail(verificationMail, token), true);
		};
	}
}

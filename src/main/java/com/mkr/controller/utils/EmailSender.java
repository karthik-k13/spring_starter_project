package com.mkr.controller.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String to, String subject, String body) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(to);
		sm.setSubject(subject);
		sm.setText(body);
		mailSender.send(sm);
	}
}

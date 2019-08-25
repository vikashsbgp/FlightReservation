package com.vikash.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl implements EmailUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtilImpl.class);
	
	@Value("${email_subject}")
	private String EMAIL_SUBJECT;
	
	@Value("${email_body}")
	private String EMAIL_BODY;

	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void sendItinerary(String toAddress, String filePath) {
		
		LOGGER.info("Inside sendItinerary()" + toAddress + "," + filePath);
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(toAddress);
			helper.setSubject(EMAIL_SUBJECT);
			helper.setText(EMAIL_BODY);
			helper.addAttachment("Itinerary", new File(filePath));
			sender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	
	}

}

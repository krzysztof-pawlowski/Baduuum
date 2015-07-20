package pl.baduuum.mail;

import java.util.Locale;

import javax.mail.MessagingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pl.baduuum.server.service.spring.EmailService;



public class MailSenderTest {
	
	@Autowired 
    private EmailService emailService;

	
	@Test
	public void sendSampleEmail(){

		String recipientName = "";
		String recipientEmail = "";
		Locale locale = null;
		try {
			this.emailService.sendSimpleMail(recipientName, recipientEmail, locale);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

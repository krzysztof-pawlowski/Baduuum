package pl.baduuum;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import pl.baduuum.server.configuration.AppConfig;

import java.util.Locale;

import javax.mail.MessagingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pl.baduuum.server.service.EmailService;



public class TestEmail {

    @Autowired
    private EmailService emailService;

    private AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    public void sendSampleEmail(){

        EmailService emailServiceBean = (EmailService) context.getBean("emailService");

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
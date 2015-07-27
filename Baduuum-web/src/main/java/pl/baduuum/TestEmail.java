package pl.baduuum;

import javax.mail.MessagingException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import pl.baduuum.server.configuration.AppConfig;
import pl.baduuum.server.service.EmailService;



public class TestEmail {

	private AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	
    public static void main (String... args){
        new TestEmail().sendSampleEmail();
    }


    public void sendSampleEmail(){

        EmailService emailServiceBean = (EmailService) context.getBean("emailService");

        String recipientName = "mariusz";
        String recipientEmail = "mario@data.pl";
        try {
            emailServiceBean.sendSimpleMail(recipientName, recipientEmail);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
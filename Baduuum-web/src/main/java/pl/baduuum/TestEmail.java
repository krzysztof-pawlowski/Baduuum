package pl.baduuum;

import javax.mail.MessagingException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import pl.baduuum.server.configuration.AppConfig;
import pl.baduuum.server.service.EmailService;
import pl.baduuum.shared.model.Reservation;

import java.sql.Time;
import java.util.Date;


public class TestEmail {

	private AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	
    public static void main (String... args){
        new TestEmail().sendSampleEmail();
    }

    public void sendSampleEmail(){

        EmailService emailServiceBean = (EmailService) context.getBean("emailService");

        Time hourStart = new Time(0);
        Time hoursEnd = new Time(10);

        Reservation reservation = new Reservation.Builder()
                .bandName("band")
                .contactPersonName("name")
                .contactPersonPhone("contactPersonPhone")
                .contactPersonEmail("mario@data.pl")
                .date(new Date())
                .hourStart(hourStart)
                .hourEnd(hoursEnd)
                .isApproved(false)
                .isCymbals(false)
                .isCymbalsCrash(false)
                .isPaid(false)
                .isPiano(false).build();

        try {
            emailServiceBean.sendReservationEmailToClient(reservation);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
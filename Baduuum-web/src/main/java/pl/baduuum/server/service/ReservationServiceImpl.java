package pl.baduuum.server.service;

import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.baduuum.client.ReservationService;
import pl.baduuum.server.configuration.AppConfig;
import pl.baduuum.shared.dao.ReservationDao;
import pl.baduuum.shared.model.Reservation;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.mail.MessagingException;

@Transactional
public class ReservationServiceImpl extends RemoteServiceServlet implements
		ReservationService {

	private static final long serialVersionUID = -1947746928337740655L;
	private static final Logger LOG = LoggerFactory.getLogger(ReservationServiceImpl.class);
	private static String notificationReceiver = "Baduuum";
	private static String notificationReceiverEmail = "baduuum@baduuum.pl";

	private AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	public ReservationServiceImpl() {
	}

	@Override
	public void submit(String name, String band, String email, String phone,
			Long day, String hourStart, String hourEnd, Boolean isPiano, Boolean isCymbals, Boolean isCymbalsCrash)  {

		Date date = new Date(day);

		Time start = convertTime(hourStart);
		Time end = convertTime(hourEnd);

		Reservation reservation = new Reservation.Builder()
				.contactPersonName(name)
				.bandName(band)
				.contactPersonEmail(email)
				.contactPersonPhone(phone)
				.date(date)
				.hourStart(start)
				.hourEnd(end)
				.isPiano(isPiano)
				.isCymbals(isCymbals)
				.isCymbalsCrash(isCymbalsCrash)
				.build();

		// save to DB
		try {
			saveReservation(reservation);
		} catch (Exception e) {
			LOG.error("Error while saving reservation to DB.", e);
			throw new RuntimeException(e);
		}
		
		// send email
		EmailService emailServiceBean = (EmailService) context.getBean("emailService");
		try {
			emailServiceBean.sendReservationEmailToClient(reservation);
			emailServiceBean.sendNotification(notificationReceiver, notificationReceiverEmail, reservation );
		} catch (MessagingException | UnsupportedEncodingException e) {
			LOG.error("Error while sending email to client.", e);
		}

	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	private void saveReservation(Reservation reservation) throws Exception {

		ReservationDao reservationDao = (ReservationDao) context.getBean("reservationDao");
		reservationDao.save(reservation);

	}

	private Time convertTime(String hourString) {

		Time time = Time.valueOf(hourString + ":00");

		return time;
	}

}

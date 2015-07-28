package pl.baduuum.server.service;

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

@Transactional
public class ReservationServiceImpl extends RemoteServiceServlet implements
		ReservationService {

	private static final long serialVersionUID = -1947746928337740655L;
	private static final Logger LOG = LoggerFactory.getLogger(ReservationServiceImpl.class);

	private AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	public ReservationServiceImpl() {
	}

	@Override
	public void submit(String name, String band, String email, String phone,
			Long date, String hourStart, String hoursEnd)  {

		// save to DB
		try {
			saveReservation(name, band, email, phone, date, hourStart, hoursEnd);
		} catch (Exception e) {
			LOG.error("Error while saving reservation to DB.", e);
		}
		
		// send email

		
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	private void saveReservation(String name, String band, String email, String phone, Long day, String hourStart, String hoursEnd) throws Exception {

		Date date = new Date(day);
		
		Time start = convertTime(hourStart);
		Time end = convertTime(hoursEnd);
		
		Reservation reservation = new Reservation.Builder()
				.build();

		ReservationDao reservationDao = (ReservationDao) context.getBean("reservationDao");
		reservationDao.save(reservation);

	}

	private Time convertTime(String hourString) {

		Time time = Time.valueOf(hourString + ":00");

		return time;
	}

}

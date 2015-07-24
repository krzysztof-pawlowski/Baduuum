package pl.baduuum.server.service;

import java.sql.Time;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.baduuum.client.ReservationService;
import pl.baduuum.server.db.configuration.AppConfig;
import pl.baduuum.shared.dao.ReservationDao;
import pl.baduuum.shared.model.ReservationCategory;
import pl.baduuum.shared.model.Reservation;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Transactional
public class ReservationServiceImpl extends RemoteServiceServlet implements
		ReservationService {

	private static final long serialVersionUID = -1947746928337740655L;
	private static final Logger LOG = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired
	private ReservationDao dao;

	private AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	public ReservationServiceImpl() {
	}

	@Override
	public void submit(String name, String band, String email, String phone,
			Long date, Long timeStart, Long timeEnd)  {
		LOG.info("after submit");
		String bandName = "name";
		String conctactPersonEmail = "cpontsanct";
		String contactPersonPhone = "phone";
		Date day = new Date();
		Time hourStart = new Time(0);
		Time hoursEnd = new Time(10)
				;
		Boolean isApproved = true;
		Boolean isCymbals = true; 
		Boolean isPaid = true;
		Boolean isPiano = true; 
		ReservationCategory reservationCategory = null;

		// save to DB
		try {
			saveReservation(bandName, conctactPersonEmail, contactPersonPhone, day, hourStart, hoursEnd, isApproved, isCymbals, isPaid, isPiano, reservationCategory);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("exception saving to db");
			LOG.info("wrong", e);
		}
		
		// send email
		
	}

	@Override
	public void saveReservation(String bandName, String conctactPersonEmail, String contactPersonPhone, Date day, Time hourStart, Time hoursEnd, Boolean isApproved, Boolean isCymbals, Boolean isPaid, Boolean isPiano, Boolean reservationCategory) {

	}



	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Integer saveReservation(String name, String conctactPersonEmail, String contactPersonPhone, Date day, Time hourStart, Time hoursEnd, Boolean isApproved, Boolean isCymbals, Boolean isPaid, Boolean isPiano, ReservationCategory reservationCategory) throws Exception {
		
		Reservation reservation = new Reservation(null, name, conctactPersonEmail, contactPersonPhone, day, hourStart, hoursEnd,
				isApproved, isCymbals, isPaid, isPiano, reservationCategory);


		ReservationDao reservationDao = (ReservationDao) context.getBean("reservationDao");
		reservationDao.save(reservation);

		return 0;
	}

}

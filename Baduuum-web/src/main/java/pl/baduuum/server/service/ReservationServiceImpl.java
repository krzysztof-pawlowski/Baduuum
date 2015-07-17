package pl.baduuum.server.service;

import java.sql.Time;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.baduuum.client.ReservationService;
import pl.baduuum.server.dao.ReservationDAO;
import pl.baduuum.shared.dto.ReservationCategoryDTO;
import pl.baduuum.shared.dto.ReservationDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ReservationServiceImpl extends RemoteServiceServlet implements
		ReservationService {

	private static final long serialVersionUID = -1947746928337740655L;
	private static final Logger LOG = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	private ReservationDAO reservationDAO;

	@Override
	public void submit(String name, String band, String email, String phone,
			Long date, Long timeStart, Long timeEnd)  {
		LOG.info("after submit");
		String bandName = "name";
		String conctactPersonEmail = "cpontsanct";
		String contactPersonPhone = "phone";
		Date day = new Date();
		Time hourStart = new Time(0);
		Time hoursEnd = new Time(10);
		Boolean isApproved = true;
		Boolean isCymbals = true; 
		Boolean isPaid = true;
		Boolean isPiano = true; 
		ReservationCategoryDTO reservationCategory = null;

		// save to DB
		try {
			saveReservation(bandName, conctactPersonEmail, contactPersonPhone, day, hourStart, hoursEnd, isApproved, isCymbals, isPaid, isPiano, reservationCategory);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("exception saving to db");
			LOG.info(e.getLocalizedMessage());
		}
		
		// send email
		
	}
	
	@PostConstruct
	public void init() {
	}
	   
	@PreDestroy
	public void destroy() {
	}
	 
	
	public ReservationDTO findReservation(int reservationId) {
		return reservationDAO.findById(reservationId);
	}
	   
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void saveReservation(String name, String conctactPersonEmail, String contactPersonPhone, Date day, Time hourStart, Time hoursEnd, Boolean isApproved, Boolean isCymbals, Boolean isPaid, Boolean isPiano, ReservationCategoryDTO reservationCategory) throws Exception {
		
		ReservationDTO reservationDTO = new ReservationDTO(null, name, conctactPersonEmail, contactPersonPhone, day, hourStart, hoursEnd,
				isApproved, isCymbals, isPaid, isPiano, reservationCategory);
		reservationDAO.persist(reservationDTO);
		
	}
	   
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void updateReservation(int id, String name) throws Exception {
	    
		ReservationDTO reservationDTO = reservationDAO.findById(id);
	    
		if(reservationDTO != null) {
			reservationDTO.setBandName(name);
		}
		reservationDAO.merge(reservationDTO);
	 }
	   
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	 public void deleteReservation(int id) throws Exception {
	    
		 ReservationDTO reservationDTO = reservationDAO.findById(id);
	    
		 	if(reservationDTO != null){
		 		reservationDAO.remove(reservationDTO);
		 	}
	 }
	   
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	 public void saveOrUpdateReservation(int id, String bandName, String conctactPersonEmail, String contactPersonPhone, Date date, Time hourStart, Time hoursEnd,
				Boolean isApproved, Boolean isCymbals, Boolean isPaid, Boolean isPiano, ReservationCategoryDTO reservationCategory) throws Exception {
		 ReservationDTO reservationDTO = new ReservationDTO(id, bandName, conctactPersonEmail, contactPersonPhone, date, hourStart, hoursEnd,
					isApproved, isCymbals, isPaid, isPiano, reservationCategory);
		 reservationDAO.merge(reservationDTO);
	 }
}

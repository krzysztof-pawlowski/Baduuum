package pl.baduuum.server.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.baduuum.client.ReservationService;
import pl.baduuum.server.dao.ReservationDAO;
import pl.baduuum.shared.dto.ReservationDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ReservationServiceImpl extends RemoteServiceServlet implements
		ReservationService {

	private static final long serialVersionUID = -1947746928337740655L;
	
	
	@Autowired
	private ReservationDAO reservationDAO;

	@Override
	public void submit(String name, String band, String email, String phone,
			Long date, Long timeStart, Long timeEnd) throws Exception {

		// save to DB
			saveReservation(null, "name");
		
		
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
	public void saveReservation(Integer id, String name) throws Exception {
		ReservationDTO reservationDTO = reservationDAO.findById(id);
		if(reservationDTO == null) {
			reservationDTO = new ReservationDTO(name);
			reservationDAO.persist(reservationDTO);
		}
	}
	   
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	 public void updateEmployee(int id, String name) throws Exception {
	    
		 ReservationDTO reservationDTO = reservationDAO.findById(id);
	    
		 if(reservationDTO != null) {
			 reservationDTO.setBandName(name);
		 }
	 }
	   
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	 public void deleteReservation(int id) throws Exception {
	    
		 ReservationDTO reservationDTO = reservationDAO.findById(id);
	    
		 	if(reservationDTO != null){
		 		reservationDAO.remove(reservationDTO);
		 	}
	 }
	   
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	 public void saveOrUpdateReservation(int id, String name) throws Exception {
		 ReservationDTO reservationDTO = new ReservationDTO(id, name);
		 reservationDAO.merge(reservationDTO);
	 }
}

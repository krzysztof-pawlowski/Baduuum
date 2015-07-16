package pl.baduuum.server.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.baduuum.shared.dto.ReservationDTO;

@Repository("reservationDAO")
public class ReservationDAO extends JpaDAO<Integer, ReservationDTO> {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;

	@PostConstruct
	public void init() {
		super.setEntityManagerFactory(entityManagerFactory);
	}

}

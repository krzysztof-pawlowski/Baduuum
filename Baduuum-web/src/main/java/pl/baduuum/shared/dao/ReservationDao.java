package pl.baduuum.shared.dao;

import java.util.List;

import pl.baduuum.shared.model.Reservation;

/**
 * Created by mario on 18/07/15.
 */
public interface ReservationDao {

    void save(Reservation reservation);

    void update(Reservation reservation);

	List<Reservation> list();
	
	Reservation findById(int id);

	void delete(Reservation reservation);

}

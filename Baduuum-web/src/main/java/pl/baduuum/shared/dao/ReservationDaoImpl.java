
package pl.baduuum.shared.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.baduuum.shared.model.Reservation;

/**
 * Created by mario on 18/07/15.
 */
@Repository("reservationDao")
public class ReservationDaoImpl implements ReservationDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
    public void save(Reservation reservation) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(reservation);
        tx.commit();
        session.close();
    }
	
	@Override
    public void update(Reservation reservation) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(reservation);
        tx.commit();
        session.close();
    }
	
	@Override
    public void delete(Reservation reservation) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(reservation);
        tx.commit();
        session.close();
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Reservation> list() {
        Session session = this.sessionFactory.openSession();
        List<Reservation> reservationList = session.createQuery("from Reservation").list();
        session.close();
        return reservationList;
    }

	@Override
	public Reservation findById(int id) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Reservation where id = :id ");
		query.setParameter("id", id);
		Reservation reservation = (Reservation) query.uniqueResult();
		session.close();
        return reservation;
	}
}
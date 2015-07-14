package pl.baduuum.db.util;

import org.hibernate.Session;

import pl.baduuum.db.model.Reservation;

public class HibernateMain {
	 
    public static void main(String[] args) {
    	Reservation reservation = new Reservation();
         
        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(reservation);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID="+reservation.getId());
         
        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }
 
}

package pl.baduuum;

import java.sql.Time;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import pl.baduuum.server.db.configuration.AppConfig;
import pl.baduuum.shared.dao.ReservationDao;
import pl.baduuum.shared.model.Reservation;
import pl.baduuum.shared.model.ReservationCategory;

/**
 * Created by mario on 19/07/15.
 */
public class Test {
    private AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);



    public static void main (String... args){
        new Test().run();
    }

    private void run() {

        String name = "name";
        String conctactPersonEmail = "cpontsanct";
        String contactPersonPhone = "phone";
        Date day = new Date();
        Time hourStart = new Time(0);
        Time hoursEnd = new Time(10);
        Boolean isApproved = true;
        Boolean isCymbals = true;
        Boolean isPaid = true;
        Boolean isPiano = true;
        ReservationCategory reservationCategory = null;

        Reservation reservation = new Reservation(null, name, name, conctactPersonEmail, contactPersonPhone, day, hourStart, hoursEnd,
                isApproved, isCymbals, isPaid, isPiano, reservationCategory);


        ReservationDao reservationDao = (ReservationDao) context.getBean("reservationDao");
        reservationDao.save(reservation);
        
        System.out.println(reservationDao.list().size());
        
        Reservation res = reservationDao.findById(1);
        reservationDao.delete(res);
        
        
        System.out.print("done");
    }
}

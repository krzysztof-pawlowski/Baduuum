package pl.baduuum;

import java.sql.Time;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import pl.baduuum.server.configuration.AppConfig;
import pl.baduuum.shared.dao.ReservationDao;
import pl.baduuum.shared.model.Reservation;
import pl.baduuum.shared.model.ReservationCategory;

/**
 * Created by mario on 19/07/15.
 */
public class TestDB {
    private AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);



    public static void main (String... args){
        new TestDB().run();
    }

    private void run() {

        Time hourStart = new Time(0);
        Time hoursEnd = new Time(10);

        Reservation reservation = new Reservation.Builder()
                .bandName("band")
                .contactPersonName("name")
                .contactPersonPhone("contactPersonPhone")
                .date(new Date())
                .hourStart(hourStart)
                .hourEnd(hoursEnd)
                .isApproved(false)
                .isCymbals(false)
                .isCymbalsCrash(false)
                .isPaid(false)
                .isPiano(false).build();


        ReservationDao reservationDao = (ReservationDao) context.getBean("reservationDao");
        reservationDao.save(reservation);


        System.out.print(reservationDao.list().size());
    }
}

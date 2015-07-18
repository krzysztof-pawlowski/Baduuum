package pl.baduuum.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.sql.Time;
import java.util.Date;

public interface ReservationServiceAsync {

    void submit(String name, String band, String email, String phone, Long date, Long timeStart, Long timeEnd, AsyncCallback<Void> callback);

    void saveReservation(String bandName, String conctactPersonEmail, String contactPersonPhone, Date day, Time hourStart, Time hoursEnd,
                         Boolean isApproved, Boolean isCymbals, Boolean isPaid, Boolean isPiano, Boolean reservationCategory, AsyncCallback<Void> async);
}

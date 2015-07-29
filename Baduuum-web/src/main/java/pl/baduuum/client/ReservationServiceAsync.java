package pl.baduuum.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.sql.Time;
import java.util.Date;

public interface ReservationServiceAsync {

    void submit(String name, String band, String email, String phone, Long date, String timeStart, String timeEnd,
                Boolean isPiano, Boolean isCymbals, Boolean isCymbalsCrash, AsyncCallback<Void> callback);

}

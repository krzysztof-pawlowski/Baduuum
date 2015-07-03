package pl.baduuum.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ReservationServiceAsync {

	void submit(String name, String band, String email, String phone, Long date, Long timeStart, Long timeEnd, AsyncCallback<Void> callback);

}

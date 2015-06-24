package pl.baduuum.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ReservationServiceAsync {

	void submit(AsyncCallback<Void> callback);

}

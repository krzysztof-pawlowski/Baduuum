package pl.baduuum.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ContactFormServiceAsync {

	void submit(String name, String email, String message, AsyncCallback<Void> callback);

}

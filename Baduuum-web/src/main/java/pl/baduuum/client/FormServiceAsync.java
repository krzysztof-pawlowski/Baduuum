package pl.baduuum.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FormServiceAsync {

	void submit(AsyncCallback<Void> callback);

}

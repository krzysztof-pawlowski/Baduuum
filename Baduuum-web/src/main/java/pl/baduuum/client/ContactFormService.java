package pl.baduuum.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("formService")
public interface ContactFormService extends RemoteService {
	public void submit(String name, String email, String message);
}

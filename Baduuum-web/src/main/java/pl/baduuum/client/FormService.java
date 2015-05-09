package pl.baduuum.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("formService")
public interface FormService extends RemoteService {
	public void submit();
}

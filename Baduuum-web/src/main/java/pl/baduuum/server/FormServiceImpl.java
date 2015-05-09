package pl.baduuum.server;

import pl.baduuum.client.FormService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class FormServiceImpl extends RemoteServiceServlet implements
		FormService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4759275195552762534L;

	@Override
	public void submit() {
		System.out.println("sending form");
		String host = "ssl0.ovh.net";

	}

}

package pl.baduuum.server;

import pl.baduuum.client.ReservationService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ReservationServiceImpl extends RemoteServiceServlet implements
		ReservationService {

	private static final long serialVersionUID = -1947746928337740655L;

	@Override
	public void submit() {
		System.out.println("submit reservation form");
	}

}

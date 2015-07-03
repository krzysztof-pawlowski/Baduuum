package pl.baduuum.server.service;

import pl.baduuum.client.ReservationService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ReservationServiceImpl extends RemoteServiceServlet implements
		ReservationService {

	private static final long serialVersionUID = -1947746928337740655L;

	@Override
	public void submit(String name, String band, String email, String phone,
			Long date, Long timeStart, Long timeEnd) {

		// save to DB
		
		
		// send email
		
	}

}

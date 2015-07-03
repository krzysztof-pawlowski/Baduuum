package pl.baduuum.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("reservationService")
public interface ReservationService extends RemoteService{

	void submit(String name, String band, String email, String phone,
			Long date, Long timeStart, Long timeEnd);
}

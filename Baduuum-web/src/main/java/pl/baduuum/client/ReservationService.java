package pl.baduuum.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.sql.Time;
import java.util.Date;

@RemoteServiceRelativePath("reservationService")
public interface ReservationService extends RemoteService{

	void submit(String name, String band, String email, String phone,
			Long date, String timeStart, String timeEnd, Boolean isPiano, Boolean isCymbals, Boolean isCymbalsCrash) throws Exception;

}

package pl.baduuum.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.sql.Time;
import java.util.Date;

@RemoteServiceRelativePath("reservationService")
public interface ReservationService extends RemoteService{

	void submit(String name, String band, String email, String phone,
			Long date, Long timeStart, Long timeEnd) throws Exception;

	void saveReservation(String bandName, String conctactPersonEmail, String contactPersonPhone, Date day, Time hourStart, Time hoursEnd,
						 Boolean isApproved, Boolean isCymbals, Boolean isPaid, Boolean isPiano, Boolean reservationCategory);
}

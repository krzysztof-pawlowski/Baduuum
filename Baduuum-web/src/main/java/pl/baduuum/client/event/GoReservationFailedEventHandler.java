package pl.baduuum.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface GoReservationFailedEventHandler extends EventHandler {
	void onGoReservationFailed(GoReservationFailedEvent event);
}
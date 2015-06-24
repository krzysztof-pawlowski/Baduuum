package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoReservationFailedEvent extends GwtEvent<GoReservationFailedEventHandler> {
	
	public static Type<GoReservationFailedEventHandler> TYPE = new Type<GoReservationFailedEventHandler>();

	@Override
	public Type<GoReservationFailedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GoReservationFailedEventHandler handler) {
		handler.onGoReservationFailed(this);
	}
}

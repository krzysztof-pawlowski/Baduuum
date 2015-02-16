package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoReservationEvent extends GwtEvent<GoReservationEventHandler> {

	public static Type<GoReservationEventHandler> TYPE = new Type<GoReservationEventHandler>();

	@Override
	public Type<GoReservationEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GoReservationEventHandler handler) {
		handler.onGoReservation(this);
	}

}

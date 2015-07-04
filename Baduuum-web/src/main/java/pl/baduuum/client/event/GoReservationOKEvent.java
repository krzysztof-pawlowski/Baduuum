package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoReservationOKEvent extends GwtEvent<GoReservationOKEventHandler> {
	
	public static Type<GoReservationOKEventHandler> TYPE = new Type<GoReservationOKEventHandler>();

	@Override
	public Type<GoReservationOKEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GoReservationOKEventHandler handler) {
		handler.onGoReservationOK(this);
	}
}

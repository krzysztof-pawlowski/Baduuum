package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoCalendarEvent extends GwtEvent<GoCalendarEventHandler> {

	public static Type<GoCalendarEventHandler> TYPE = new Type<GoCalendarEventHandler>();

	@Override
	public Type<GoCalendarEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GoCalendarEventHandler handler) {
		handler.onGoCalendar(this);
	}
}

package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoContactFailedEvent extends GwtEvent<GoContactFailedEventHandler> {
	
	public static Type<GoContactFailedEventHandler> TYPE = new Type<GoContactFailedEventHandler>();

	@Override
	public Type<GoContactFailedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GoContactFailedEventHandler handler) {
		handler.onGoContactFailed(this);
	}
}

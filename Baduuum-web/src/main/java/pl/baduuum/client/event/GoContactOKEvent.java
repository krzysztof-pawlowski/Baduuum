package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoContactOKEvent extends GwtEvent<GoContactOKEventHandler> {
	
	public static Type<GoContactOKEventHandler> TYPE = new Type<GoContactOKEventHandler>();

	@Override
	public Type<GoContactOKEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GoContactOKEventHandler handler) {
		handler.onGoContactOK(this);
	}
}

package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoContactEvent extends GwtEvent<GoContactEventHandler> {
	
	public static Type<GoContactEventHandler> TYPE = new Type<GoContactEventHandler>();

	@Override
	public Type<GoContactEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GoContactEventHandler handler) {
		handler.onGoContact(this);
	}
}

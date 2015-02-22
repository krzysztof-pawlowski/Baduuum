package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoStudioEvent extends GwtEvent<GoStudioEventHandler> {
	
	public static Type<GoStudioEventHandler> TYPE = new Type<GoStudioEventHandler>();

	@Override
	public Type<GoStudioEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GoStudioEventHandler handler) {
		handler.onGoStudio(this);
	}
}


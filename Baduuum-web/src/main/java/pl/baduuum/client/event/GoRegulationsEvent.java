package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoRegulationsEvent extends GwtEvent<GoRegulationsEventHandler> {
	public static Type<GoRegulationsEventHandler> TYPE = new Type<GoRegulationsEventHandler>();

	@Override
	public Type<GoRegulationsEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GoRegulationsEventHandler handler) {
		handler.onGoRegulations(this);
	}

}

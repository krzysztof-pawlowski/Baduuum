package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoRoomEvent extends GwtEvent<GoRoomEventHandler> {
	
	public static Type<GoRoomEventHandler> TYPE = new Type<GoRoomEventHandler>();

	@Override
	public Type<GoRoomEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(GoRoomEventHandler handler) {
		handler.onGoRoom(this);
	}

}

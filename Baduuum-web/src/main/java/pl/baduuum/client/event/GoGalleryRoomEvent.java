package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoGalleryRoomEvent extends GwtEvent<GoGalleryRoomEventHandler> {
	  public static Type<GoGalleryRoomEventHandler> TYPE = new Type<GoGalleryRoomEventHandler>();
	  
	  @Override
	  public Type<GoGalleryRoomEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(GoGalleryRoomEventHandler handler) {
		  handler.onGoGalleryRoom(this);
	  }
}

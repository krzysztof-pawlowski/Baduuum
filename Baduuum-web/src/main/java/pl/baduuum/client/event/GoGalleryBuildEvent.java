package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoGalleryBuildEvent extends GwtEvent<GoGalleryBuildEventHandler> {
	  public static Type<GoGalleryBuildEventHandler> TYPE = new Type<GoGalleryBuildEventHandler>();
	  
	  @Override
	  public Type<GoGalleryBuildEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(GoGalleryBuildEventHandler handler) {
		  handler.onGoGalleryBuild(this);
	  }
}

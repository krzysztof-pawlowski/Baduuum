package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoFaqEvent extends GwtEvent<GoFaqEventHandler> {
	  public static Type<GoFaqEventHandler> TYPE = new Type<GoFaqEventHandler>();
	  
	  @Override
	  public Type<GoFaqEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(GoFaqEventHandler handler) {
		  handler.onGoFaq(this);
	  }
}

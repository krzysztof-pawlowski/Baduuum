package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class TestEvent extends GwtEvent<TestEventHandler>{
	  public static Type<TestEventHandler> TYPE = new Type<TestEventHandler>();
	  
	  @Override
	  public Type<TestEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(TestEventHandler handler) {
	    handler.onAddContact(this);
	  }
}

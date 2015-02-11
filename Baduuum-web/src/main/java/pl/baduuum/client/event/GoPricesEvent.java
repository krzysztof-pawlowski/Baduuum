package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class GoPricesEvent extends GwtEvent<GoPricesEventHandler> {
	  public static Type<GoPricesEventHandler> TYPE = new Type<GoPricesEventHandler>();
	  
	  @Override
	  public Type<GoPricesEventHandler> getAssociatedType() {
	    return TYPE;
	  }

	  @Override
	  protected void dispatch(GoPricesEventHandler handler) {
	    handler.onGoPrices(this);
	  }

}
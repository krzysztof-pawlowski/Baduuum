package pl.baduuum.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by Mariusz.Pawlowski on 2015-07-31.
 */
public class GoAdminEvent extends GwtEvent<GoAdminEventHandler> {

    public static Type<GoAdminEventHandler> TYPE = new Type<GoAdminEventHandler>();

    @Override
    public Type<GoAdminEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(GoAdminEventHandler handler) {
        handler.onGoAdmin(this);
    }
}

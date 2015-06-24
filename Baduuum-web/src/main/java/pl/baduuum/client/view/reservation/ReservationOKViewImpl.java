package pl.baduuum.client.view.reservation;

import pl.baduuum.client.StyleResources;
import pl.baduuum.client.view.BaduuumView;
import pl.baduuum.client.view.widgets.MenuWidgetView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ReservationOKViewImpl extends Composite implements BaduuumView {

	@UiField StyleResources res;
	
	@UiField MenuWidgetView menu;
	
	@UiTemplate("ReservationOKView.ui.xml")
	interface BaduuumReservationOKViewUiBinder extends UiBinder<Widget, ReservationOKViewImpl> {
	}

	private static BaduuumReservationOKViewUiBinder uiBinder = GWT.create(BaduuumReservationOKViewUiBinder.class);
	
	public ReservationOKViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		res.style().ensureInjected();
	}
	
	public Widget asWidget() {
		return this;
	}
}
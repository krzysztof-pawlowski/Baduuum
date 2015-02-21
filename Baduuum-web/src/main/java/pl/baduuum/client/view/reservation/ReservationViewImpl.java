package pl.baduuum.client.view.reservation;

import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ReservationViewImpl extends Composite implements BaduuumView {

	@UiTemplate("ReservationView.ui.xml")
	interface BaduuumReservationViewUiBinder extends UiBinder<Widget, ReservationViewImpl> {
	}

	private static BaduuumReservationViewUiBinder uiBinder = GWT.create(BaduuumReservationViewUiBinder.class);
	
	public ReservationViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
	}

	public Widget asWidget() {
		return this;
	}
}

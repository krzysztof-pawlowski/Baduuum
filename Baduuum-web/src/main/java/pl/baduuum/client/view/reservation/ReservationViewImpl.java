package pl.baduuum.client.view.reservation;

import pl.baduuum.client.view.BaduuumView;
import pl.baduuum.client.view.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class ReservationViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("ReservationView.ui.xml")
	interface BaduuumReservationViewUiBinder extends UiBinder<Widget, ReservationViewImpl> {
	}

	private static BaduuumReservationViewUiBinder uiBinder = GWT.create(BaduuumReservationViewUiBinder.class);
	
	private Presenter presenter;

	public ReservationViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	public Widget asWidget() {
		return this;
	}

	@Override
	public void initializeMenu() {
		setCommands(presenter);
	}
}

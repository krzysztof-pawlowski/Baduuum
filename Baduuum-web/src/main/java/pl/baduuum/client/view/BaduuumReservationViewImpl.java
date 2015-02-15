package pl.baduuum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumReservationViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("BaduuumReservationView.ui.xml")
	interface BaduuumReservationViewUiBinder extends UiBinder<Widget, BaduuumReservationViewImpl> {
	}

	private static BaduuumReservationViewUiBinder uiBinder = GWT.create(BaduuumReservationViewUiBinder.class);
	
	private Presenter presenter;

	public BaduuumReservationViewImpl() {
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

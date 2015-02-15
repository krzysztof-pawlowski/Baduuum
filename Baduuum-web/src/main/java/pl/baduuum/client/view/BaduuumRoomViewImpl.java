package pl.baduuum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumRoomViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("BaduuumRoomView.ui.xml")
	interface BaduuumRoomViewUiBinder extends UiBinder<Widget, BaduuumRoomViewImpl> {
	}

	private static BaduuumRoomViewUiBinder uiBinder = GWT.create(BaduuumRoomViewUiBinder.class);
	
	private Presenter presenter;

	public BaduuumRoomViewImpl() {
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

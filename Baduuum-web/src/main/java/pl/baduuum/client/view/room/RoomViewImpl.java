package pl.baduuum.client.view.room;

import pl.baduuum.client.view.BaduuumView;
import pl.baduuum.client.view.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class RoomViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("RoomView.ui.xml")
	interface BaduuumRoomViewUiBinder extends UiBinder<Widget, RoomViewImpl> {
	}

	private static BaduuumRoomViewUiBinder uiBinder = GWT.create(BaduuumRoomViewUiBinder.class);
	
	private Presenter presenter;

	public RoomViewImpl() {
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

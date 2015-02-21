package pl.baduuum.client.view.room;

import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class RoomViewImpl extends Composite implements BaduuumView {

	@UiTemplate("RoomView.ui.xml")
	interface BaduuumRoomViewUiBinder extends UiBinder<Widget, RoomViewImpl> {
	}

	private static BaduuumRoomViewUiBinder uiBinder = GWT.create(BaduuumRoomViewUiBinder.class);
	
	public RoomViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
	}
	
	public Widget asWidget() {
		return this;
	}
}

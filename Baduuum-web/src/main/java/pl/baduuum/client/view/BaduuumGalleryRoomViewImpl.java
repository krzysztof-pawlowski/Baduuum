package pl.baduuum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumGalleryRoomViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("BaduuumGalleryRoomView.ui.xml")
	interface BaduuumGalleryRoomViewUiBinder extends UiBinder<Widget, BaduuumGalleryRoomViewImpl> {
	}

	private static BaduuumGalleryRoomViewUiBinder uiBinder = GWT.create(BaduuumGalleryRoomViewUiBinder.class);
	
	private Presenter presenter;

	public BaduuumGalleryRoomViewImpl() {
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

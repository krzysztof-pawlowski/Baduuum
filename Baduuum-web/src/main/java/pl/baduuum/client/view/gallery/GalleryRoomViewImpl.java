package pl.baduuum.client.view.gallery;

import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GalleryRoomViewImpl extends Composite implements BaduuumView {

	@UiTemplate("GalleryRoomView.ui.xml")
	interface BaduuumGalleryRoomViewUiBinder extends UiBinder<Widget, GalleryRoomViewImpl> {
	}

	private static BaduuumGalleryRoomViewUiBinder uiBinder = GWT.create(BaduuumGalleryRoomViewUiBinder.class);

	public GalleryRoomViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
	}
	
	public Widget asWidget() {
		return this;
	}
}

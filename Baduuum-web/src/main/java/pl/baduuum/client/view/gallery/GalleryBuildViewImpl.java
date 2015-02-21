package pl.baduuum.client.view.gallery;

import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GalleryBuildViewImpl extends Composite implements BaduuumView {

	@UiTemplate("GalleryBuildView.ui.xml")
	interface BaduuumGalleryBuildViewUiBinder extends UiBinder<Widget, GalleryBuildViewImpl> {
	}

	private static BaduuumGalleryBuildViewUiBinder uiBinder = GWT.create(BaduuumGalleryBuildViewUiBinder.class);
	
	public GalleryBuildViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
	}

	public Widget asWidget() {
		return this;
	}
}

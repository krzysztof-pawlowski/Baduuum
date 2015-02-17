package pl.baduuum.client.view.gallery;

import pl.baduuum.client.view.BaduuumView;
import pl.baduuum.client.view.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class GalleryBuildViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("GalleryBuildView.ui.xml")
	interface BaduuumGalleryBuildViewUiBinder extends UiBinder<Widget, GalleryBuildViewImpl> {
	}

	private static BaduuumGalleryBuildViewUiBinder uiBinder = GWT.create(BaduuumGalleryBuildViewUiBinder.class);
	
	private Presenter presenter;

	public GalleryBuildViewImpl() {
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

package pl.baduuum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumGalleryBuildViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("BaduuumGalleryBuildView.ui.xml")
	interface BaduuumGalleryBuildViewUiBinder extends UiBinder<Widget, BaduuumGalleryBuildViewImpl> {
	}

	private static BaduuumGalleryBuildViewUiBinder uiBinder = GWT.create(BaduuumGalleryBuildViewUiBinder.class);
	
	private Presenter presenter;

	public BaduuumGalleryBuildViewImpl() {
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

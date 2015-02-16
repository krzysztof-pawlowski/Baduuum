package pl.baduuum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumHomeViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("BaduuumHomeView.ui.xml")
	interface BaduuumHomeViewUiBinder extends UiBinder<Widget, BaduuumHomeViewImpl> {
	}

	private static BaduuumHomeViewUiBinder uiBinder = GWT.create(BaduuumHomeViewUiBinder.class);
	
	private Presenter presenter;

	public BaduuumHomeViewImpl() {
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
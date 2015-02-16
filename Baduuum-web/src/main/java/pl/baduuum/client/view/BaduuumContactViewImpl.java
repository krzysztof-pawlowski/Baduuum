package pl.baduuum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumContactViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("BaduuumContactView.ui.xml")
	interface BaduuumContactViewUiBinder extends UiBinder<Widget, BaduuumContactViewImpl> {
	}

	private static BaduuumContactViewUiBinder uiBinder = GWT.create(BaduuumContactViewUiBinder.class);
	
	private Presenter presenter;

	public BaduuumContactViewImpl() {
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

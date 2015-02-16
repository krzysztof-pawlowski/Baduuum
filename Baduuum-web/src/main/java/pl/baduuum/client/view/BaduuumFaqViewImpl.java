package pl.baduuum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumFaqViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("BaduuumFaqView.ui.xml")
	interface BaduuumFaqViewUiBinder extends UiBinder<Widget, BaduuumFaqViewImpl> {
	}

	private static BaduuumFaqViewUiBinder uiBinder = GWT.create(BaduuumFaqViewUiBinder.class);
	
	private Presenter presenter;

	public BaduuumFaqViewImpl() {
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

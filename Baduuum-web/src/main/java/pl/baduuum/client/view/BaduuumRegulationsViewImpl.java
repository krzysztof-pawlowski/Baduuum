package pl.baduuum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumRegulationsViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("BaduuumRegulationsView.ui.xml")
	interface BaduuumRegulaionsViewUiBinder extends UiBinder<Widget, BaduuumRegulationsViewImpl> {
	}

	private static BaduuumRegulaionsViewUiBinder uiBinder = GWT.create(BaduuumRegulaionsViewUiBinder.class);
	
	private Presenter presenter;

	public BaduuumRegulationsViewImpl() {
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

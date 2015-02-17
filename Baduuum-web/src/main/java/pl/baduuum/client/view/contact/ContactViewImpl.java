package pl.baduuum.client.view.contact;

import pl.baduuum.client.view.BaduuumView;
import pl.baduuum.client.view.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class ContactViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("ContactView.ui.xml")
	interface BaduuumContactViewUiBinder extends UiBinder<Widget, ContactViewImpl> {
	}

	private static BaduuumContactViewUiBinder uiBinder = GWT.create(BaduuumContactViewUiBinder.class);
	
	private Presenter presenter;

	public ContactViewImpl() {
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

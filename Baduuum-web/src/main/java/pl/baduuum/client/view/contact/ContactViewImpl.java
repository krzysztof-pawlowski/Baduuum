package pl.baduuum.client.view.contact;

import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ContactViewImpl extends Composite implements BaduuumView {

	@UiTemplate("ContactView.ui.xml")
	interface BaduuumContactViewUiBinder extends UiBinder<Widget, ContactViewImpl> {
	}

	private static BaduuumContactViewUiBinder uiBinder = GWT.create(BaduuumContactViewUiBinder.class);
	
	public ContactViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
	}
	
	public Widget asWidget() {
		return this;
	}

}

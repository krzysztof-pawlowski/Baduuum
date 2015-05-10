package pl.baduuum.client.view.contact;

import pl.baduuum.client.StyleResources;
import pl.baduuum.client.view.BaduuumView;
import pl.baduuum.client.view.widgets.MenuWidgetView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ContactFailedViewImpl extends Composite implements BaduuumView {

	@UiField StyleResources res;
	
	@UiField MenuWidgetView menu;
	
	@UiTemplate("ContactFailedView.ui.xml")
	interface BaduuumContactFailedViewUiBinder extends UiBinder<Widget, ContactFailedViewImpl> {
	}

	private static BaduuumContactFailedViewUiBinder uiBinder = GWT.create(BaduuumContactFailedViewUiBinder.class);
	
	public ContactFailedViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		res.style().ensureInjected();
	}
	
	public Widget asWidget() {
		return this;
	}
}

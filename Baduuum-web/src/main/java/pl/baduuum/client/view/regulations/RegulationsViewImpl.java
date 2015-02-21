package pl.baduuum.client.view.regulations;

import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class RegulationsViewImpl extends Composite implements BaduuumView {

	@UiTemplate("RegulationsView.ui.xml")
	interface BaduuumRegulaionsViewUiBinder extends UiBinder<Widget, RegulationsViewImpl> {
	}

	private static BaduuumRegulaionsViewUiBinder uiBinder = GWT.create(BaduuumRegulaionsViewUiBinder.class);
	
	public RegulationsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
	}
	
	public Widget asWidget() {
		return this;
	}
}

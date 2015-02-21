package pl.baduuum.client.view.faq;

import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FaqViewImpl extends Composite implements BaduuumView {

	@UiTemplate("FaqView.ui.xml")
	interface BaduuumFaqViewUiBinder extends UiBinder<Widget, FaqViewImpl> {
	}

	private static BaduuumFaqViewUiBinder uiBinder = GWT.create(BaduuumFaqViewUiBinder.class);
	
	public FaqViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
	}
	
	public Widget asWidget() {
		return this;
	}
}

package pl.baduuum.client.view.home;

import pl.baduuum.client.StyleResources;
import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomeViewImpl extends Composite implements BaduuumView {

	@UiField StyleResources res;
	
	@UiTemplate("HomeView.ui.xml")
	interface BaduuumHomeViewUiBinder extends UiBinder<Widget, HomeViewImpl> {
	}

	private static BaduuumHomeViewUiBinder uiBinder = GWT.create(BaduuumHomeViewUiBinder.class);
	
	public HomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		res.style().ensureInjected();
	}
	
	public Widget asWidget() {
		return this;
	}
}

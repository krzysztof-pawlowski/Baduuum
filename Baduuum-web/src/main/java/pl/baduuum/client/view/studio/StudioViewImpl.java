package pl.baduuum.client.view.studio;

import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class StudioViewImpl extends Composite implements BaduuumView {

	@UiTemplate("StudioView.ui.xml")
	interface BaduuumStudioViewUiBinder extends UiBinder<Widget, StudioViewImpl> {
	}

	private static BaduuumStudioViewUiBinder uiBinder = GWT.create(BaduuumStudioViewUiBinder.class);
	
	public StudioViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
	}
	
	public Widget asWidget() {
		return this;
	}
}

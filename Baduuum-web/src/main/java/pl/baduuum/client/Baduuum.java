package pl.baduuum.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Baduuum extends Composite {

	private static BaduuumUiBinder uiBinder = GWT.create(BaduuumUiBinder.class);

	@UiTemplate("Baduuum.ui.xml")
	interface BaduuumUiBinder extends UiBinder<Widget, Baduuum> {
	}

	@UiField
	TextBox loginBox;

	@UiField
	MenuItem buttonHome;

	@UiField(provided = true)
	final BaduuumResources res;
	

	public Baduuum() {
		this.res = GWT.create(BaduuumResources.class);
		res.style().ensureInjected();
		
		initWidget(uiBinder.createAndBindUi(this));
		Command cmd = new Command() {
			@Override
			public void execute() {
				Window.alert("  Gifts  ");
				
			}
		};

		buttonHome.setScheduledCommand(cmd);
	}

}
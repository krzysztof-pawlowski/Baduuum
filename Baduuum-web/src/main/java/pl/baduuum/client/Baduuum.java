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

	/*
	 * @UiField TextBox passwordBox;
	 * 
	 * @UiField Label completionLabel1;
	 * 
	 * @UiField Label completionLabel2;
	 * 
	 * private Boolean tooShort = false;
	 * 
	 * @UiHandler("buttonSubmit") void doClickSubmit(ClickEvent event) { if (tooShort) { Window.alert("Login Successful!"); } else { Window.alert("Login or Password is too short!"); } }
	 * 
	 * @UiHandler("loginBox") void handleLoginChange(ValueChangeEvent<String> event) { if (event.getValue().length() < 6) { completionLabel1.setText("Login too short (Size must be > 6)"); tooShort = true; } else { tooShort = false; completionLabel1.setText(""); } }
	 * 
	 * @UiHandler("passwordBox") void handlePasswordChange(ValueChangeEvent<String> event) { if (event.getValue().length() < 6) { tooShort = true; completionLabel2.setText("Password too short (Size must be > 6)"); } else { tooShort = false; completionLabel2.setText(""); } }
	 */
}
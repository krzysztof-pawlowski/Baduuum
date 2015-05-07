package pl.baduuum.client.view.contact;

import pl.baduuum.client.BaduuumService;
import pl.baduuum.client.BaduuumServiceAsync;
import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ContactViewImpl extends Composite implements BaduuumView {

	@UiField
	TextBox name;

	@UiField
	TextBox email;

	@UiField
	TextArea message;

	@UiField
	FormPanel form;
	
	private final BaduuumServiceAsync service = GWT.create(BaduuumService.class);
	
	

	@UiTemplate("ContactView.ui.xml")
	interface BaduuumContactViewUiBinder extends
			UiBinder<Widget, ContactViewImpl> {
	}

	private static BaduuumContactViewUiBinder uiBinder = GWT
			.create(BaduuumContactViewUiBinder.class);

	public ContactViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		name.getElement().setPropertyString("placeholder", "Imię i nazwisko");
		email.getElement().setPropertyString("placeholder", "Adres e-mail");
		message.getElement().setPropertyString("placeholder", "Wiadomość");
		
		form.setMethod(FormPanel.METHOD_POST);
		form.setEncoding(FormPanel.ENCODING_MULTIPART);
		
	}

	public Widget asWidget() {
		return this;
	}

	@UiHandler("buttonSubmit")
	void doClickSubmit(ClickEvent event) {
		String host = "ssl0.ovh.net";
	}

}

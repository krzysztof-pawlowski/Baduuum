package pl.baduuum.client.view.contact;

import pl.baduuum.PageConstants;
import pl.baduuum.client.FormService;
import pl.baduuum.client.FormServiceAsync;
import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.History;
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
	
	private FormServiceAsync service = GWT.create(FormService.class);

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
		if (service == null){
			service = GWT.create(FormService.class);
		}
		
		AsyncCallback<Void> callback = new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				History.newItem(PageConstants.CONTACT_FAILED);
			}

			@Override
			public void onSuccess(Void result) {
				History.newItem(PageConstants.CONTACT_OK);
			}
		};
		
		service.submit(name.getText(), email.getText(), message.getText(), callback);
		
	}

}

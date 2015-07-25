package pl.baduuum.client.view.reservation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.baduuum.PageConstants;
import pl.baduuum.client.ReservationService;
import pl.baduuum.client.ReservationServiceAsync;
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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.tractionsoftware.gwt.user.client.ui.UTCDateBox;
import com.tractionsoftware.gwt.user.client.ui.UTCTimeBox;

import java.time.LocalTime;

public class ReservationViewImpl extends Composite implements BaduuumView {
	
	@UiField
	FormPanel form;
	
	@UiField
	TextBox nameField;
	
	@UiField
	TextBox bandField;
	
	@UiField
	TextBox emailField;
	
	@UiField
	TextBox phoneField;
	
	@UiField 
	UTCDateBox dateField;
	
	@UiField 
	UTCTimeBox timeStartField;
	
	@UiField 
	UTCTimeBox timeEndField;
	
	private ReservationServiceAsync service = GWT.create(ReservationService.class);

	@UiTemplate("ReservationView.ui.xml")
	interface BaduuumReservationViewUiBinder extends UiBinder<Widget, ReservationViewImpl> {
	}

	private static BaduuumReservationViewUiBinder uiBinder = GWT.create(BaduuumReservationViewUiBinder.class);
	public ReservationViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
		
		nameField.getElement().setPropertyString("placeholder", "osoba kontaktowa");
		bandField.getElement().setPropertyString("placeholder", "zespół");
		emailField.getElement().setPropertyString("placeholder", "e-mail");
		phoneField.getElement().setPropertyString("placeholder", "telefon");
		dateField.getElement().setPropertyString("placeholder", "dzień");
		timeStartField.getElement().setPropertyString("placeholder", "godzina rozpoczęcia");
		timeEndField.getElement().setPropertyString("placeholder", "godzina zakończenia");
		
		form.setMethod(FormPanel.METHOD_POST);
		form.setEncoding(FormPanel.ENCODING_MULTIPART);
	}
	
	@UiHandler("buttonSubmit")
	void doClickSubmit(ClickEvent event) {
		if (service == null){
			service = GWT.create(ReservationService.class);
		}
		
		AsyncCallback<Void> callback = new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				History.newItem(PageConstants.RESERVATION_FAILED);
			}

			@Override
			public void onSuccess(Void result) {
				History.newItem(PageConstants.RESERVATION_OK);
			}
		};
		
		String name = nameField.getText();
		String band = bandField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		Long date = dateField.getValue();

		String timeStart = timeStartField.getText();
		String timeEnd = timeEndField.getText();
		service.submit(name, band, email, phone, date, timeStart, timeEnd, callback);
		
	}

	public Widget asWidget() {
		return this;
	}
}

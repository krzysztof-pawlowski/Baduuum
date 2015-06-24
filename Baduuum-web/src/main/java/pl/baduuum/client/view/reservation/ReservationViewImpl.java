package pl.baduuum.client.view.reservation;

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

public class ReservationViewImpl extends Composite implements BaduuumView {
	
	@UiField
	FormPanel form;
	
	@UiField
	TextBox name;
	
	@UiField
	TextBox band;
	
	@UiField
	TextBox email;
	
	@UiField
	TextBox phone;
	
	@UiField 
	UTCDateBox date;
	
	@UiField 
	UTCTimeBox timeStart;
	
	@UiField 
	UTCTimeBox timeEnd;
	
	private ReservationServiceAsync service = GWT.create(ReservationService.class);

	@UiTemplate("ReservationView.ui.xml")
	interface BaduuumReservationViewUiBinder extends UiBinder<Widget, ReservationViewImpl> {
	}

	private static BaduuumReservationViewUiBinder uiBinder = GWT.create(BaduuumReservationViewUiBinder.class);
	
	public ReservationViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
		
		name.getElement().setPropertyString("placeholder", "osoba kontaktowa");
		band.getElement().setPropertyString("placeholder", "zespół");
		email.getElement().setPropertyString("placeholder", "e-mail");
		phone.getElement().setPropertyString("placeholder", "telefon");
		date.getElement().setPropertyString("placeholder", "dzień");
		timeStart.getElement().setPropertyString("placeholder", "godzina rozpoczęcia");
		timeEnd.getElement().setPropertyString("placeholder", "godzina zakończenia");
		
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
		
		service.submit(callback);
		
	}

	public Widget asWidget() {
		return this;
	}
}

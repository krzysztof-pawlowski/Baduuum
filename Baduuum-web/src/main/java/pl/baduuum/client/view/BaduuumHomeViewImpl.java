package pl.baduuum.client.view;

import pl.baduuum.client.view.commands.CalendarCommand;
import pl.baduuum.client.view.commands.ContactCommand;
import pl.baduuum.client.view.commands.FaqCommand;
import pl.baduuum.client.view.commands.GalleryBuildCommand;
import pl.baduuum.client.view.commands.GalleryRoomCommand;
import pl.baduuum.client.view.commands.HomeCommand;
import pl.baduuum.client.view.commands.PricesCommand;
import pl.baduuum.client.view.commands.RegulationsCommand;
import pl.baduuum.client.view.commands.ReservationCommand;
import pl.baduuum.client.view.commands.RoomCommand;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumHomeViewImpl extends Composite implements BaduuumView {

	@UiTemplate("BaduuumHomeView.ui.xml")
	interface BaduuumHomeViewUiBinder extends UiBinder<Widget, BaduuumHomeViewImpl> {
	}

	private static BaduuumHomeViewUiBinder uiBinder = GWT.create(BaduuumHomeViewUiBinder.class);

	@UiField MenuItem buttonHome;
	@UiField MenuItem buttonPrice;
	@UiField MenuItem buttonCalendar;
	@UiField MenuItem buttonRoom;
	@UiField MenuItem buttonReservation;
	@UiField MenuItem buttonGalleryRoom;
	@UiField MenuItem buttonGalleryBuild;
	@UiField MenuItem buttonRegulations;
	@UiField MenuItem buttonFAQ;
	@UiField MenuItem buttonContact;
	
	private Presenter presenter;

	public BaduuumHomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	public Widget asWidget() {
		return this;
	}

	@Override
	public void initializeMenu() {
		buttonHome.setScheduledCommand(new HomeCommand(presenter));
		buttonPrice.setScheduledCommand(new PricesCommand(presenter));
		buttonCalendar.setScheduledCommand(new CalendarCommand(presenter));
		buttonRoom.setScheduledCommand(new RoomCommand(presenter));
		buttonReservation.setScheduledCommand(new ReservationCommand(presenter));
		buttonGalleryRoom.setScheduledCommand(new GalleryRoomCommand(presenter));
		buttonGalleryBuild.setScheduledCommand(new GalleryBuildCommand(presenter));
		buttonRegulations.setScheduledCommand(new RegulationsCommand(presenter));
		buttonFAQ.setScheduledCommand(new FaqCommand(presenter));
		buttonContact.setScheduledCommand(new ContactCommand(presenter));	
		
	}
}

package pl.baduuum.client.view;

import pl.baduuum.client.view.BaduuumView.Presenter;
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

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuItem;

public class BaseView extends Composite {
	
	public @UiField MenuItem buttonHome;
	public @UiField MenuItem buttonPrice;
	public @UiField MenuItem buttonCalendar;
	public @UiField MenuItem buttonRoom;
	public @UiField MenuItem buttonReservation;
	public @UiField MenuItem buttonGalleryRoom;
	public @UiField MenuItem buttonGalleryBuild;
	public @UiField MenuItem buttonRegulations;
	public @UiField MenuItem buttonFAQ;
	public @UiField MenuItem buttonContact;

	public void setCommands(Presenter presenter){
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

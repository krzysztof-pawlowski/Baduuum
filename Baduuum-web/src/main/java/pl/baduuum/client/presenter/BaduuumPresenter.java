package pl.baduuum.client.presenter;

import pl.baduuum.client.BaduuumServiceAsync;
import pl.baduuum.client.event.GoCalendarEvent;
import pl.baduuum.client.event.GoContactEvent;
import pl.baduuum.client.event.GoFaqEvent;
import pl.baduuum.client.event.GoGalleryBuildEvent;
import pl.baduuum.client.event.GoGalleryRoomEvent;
import pl.baduuum.client.event.GoHomeEvent;
import pl.baduuum.client.event.GoPricesEvent;
import pl.baduuum.client.event.GoRegulationsEvent;
import pl.baduuum.client.event.GoReservationEvent;
import pl.baduuum.client.event.GoRoomEvent;
import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class BaduuumPresenter implements Presenter, BaduuumView.Presenter {

	private final BaduuumServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final BaduuumView view;

	public BaduuumPresenter(BaduuumServiceAsync rpcService, HandlerManager eventBus, BaduuumView view) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.view = view;
		this.view.setPresenter(this);
		this.view.initializeMenu();

	}
	
	@Override
	public void onHomeButtonClicked() {
		eventBus.fireEvent(new GoHomeEvent());
	}
	
	@Override
	public void onPricesButtonClicked() {
		eventBus.fireEvent(new GoPricesEvent());
	}
	
	@Override
	public void onCalendarButtonClicked() {
		eventBus.fireEvent(new GoCalendarEvent());
	}

	@Override
	public void onContactButtonClicked() {
		eventBus.fireEvent(new GoContactEvent());
	}

	@Override
	public void onFaqButtonClicked() {
		eventBus.fireEvent(new GoFaqEvent());
	}

	@Override
	public void onGalleryBuildButtonClicked() {
		eventBus.fireEvent(new GoGalleryBuildEvent());		
	}

	@Override
	public void onGalleryRoomButtonClicked() {
		eventBus.fireEvent(new GoGalleryRoomEvent());
	}

	@Override
	public void onRegulationsButtonClicked() {
		eventBus.fireEvent(new GoRegulationsEvent());
	}

	@Override
	public void onReservationButtonClicked() {
		eventBus.fireEvent(new GoReservationEvent());
	}

	@Override
	public void onRoomButtonClicked() {
		eventBus.fireEvent(new GoRoomEvent());
	}

	public void go(final HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
	}
}

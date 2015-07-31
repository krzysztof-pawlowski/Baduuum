package pl.baduuum.client;

import pl.baduuum.PageConstants;
import pl.baduuum.client.event.*;
import pl.baduuum.client.presenter.BaduuumPresenter;
import pl.baduuum.client.presenter.Presenter;
import pl.baduuum.client.view.admin.AdminViewImpl;
import pl.baduuum.client.view.calendar.CalendarViewImpl;
import pl.baduuum.client.view.contact.ContactFailedViewImpl;
import pl.baduuum.client.view.contact.ContactOKViewImpl;
import pl.baduuum.client.view.contact.ContactViewImpl;
import pl.baduuum.client.view.faq.FaqViewImpl;
import pl.baduuum.client.view.gallery.GalleryBuildViewImpl;
import pl.baduuum.client.view.gallery.GalleryRoomViewImpl;
import pl.baduuum.client.view.home.HomeViewImpl;
import pl.baduuum.client.view.prices.PricesViewImpl;
import pl.baduuum.client.view.regulations.RegulationsViewImpl;
import pl.baduuum.client.view.reservation.ReservationFailedViewImpl;
import pl.baduuum.client.view.reservation.ReservationOKViewImpl;
import pl.baduuum.client.view.reservation.ReservationViewImpl;
import pl.baduuum.client.view.room.RoomViewImpl;
import pl.baduuum.client.view.studio.StudioViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {

	
	private final HandlerManager eventBus;
	private HasWidgets container;
	
	private HomeViewImpl homeView = null;
	private PricesViewImpl pricesView = null;
	private CalendarViewImpl calendarView = null;
	private RoomViewImpl roomView = null;
	private StudioViewImpl studioView = null;
	private ReservationViewImpl reservationView = null;
	private GalleryRoomViewImpl galleryRoomView = null;
	private GalleryBuildViewImpl galleryBuildView = null;
	private RegulationsViewImpl regulationsView = null;
	private FaqViewImpl faqView = null;
	private ContactViewImpl contactView = null;
	private ContactOKViewImpl contactOKView = null;
	private ContactFailedViewImpl contactFailedView = null;
	private ReservationOKViewImpl reservationOKView = null;
	private ReservationFailedViewImpl reservationFailedView = null;
	private AdminViewImpl adminView = null;

	public AppController(HandlerManager eventBus) {
		this.eventBus = eventBus;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(GoHomeEvent.TYPE, new GoHomeEventHandler() {
			@Override
			public void onGoHome(GoHomeEvent event) {
				doOpenPage(PageConstants.HOME);
			}
		});

		eventBus.addHandler(GoPricesEvent.TYPE, new GoPricesEventHandler() {
			@Override
			public void onGoPrices(GoPricesEvent event) {
				doOpenPage(PageConstants.PRICES);
			}
		});
		
		eventBus.addHandler(GoCalendarEvent.TYPE, new GoCalendarEventHandler() {
			@Override
			public void onGoCalendar(GoCalendarEvent event) {
				doOpenPage(PageConstants.CALENDAR);
				
			}
		});
		
		eventBus.addHandler(GoContactEvent.TYPE, new GoContactEventHandler() {
			@Override
			public void onGoContact(GoContactEvent event) {
				doOpenPage(PageConstants.CONTACT);
			}
		});
		
		eventBus.addHandler(GoFaqEvent.TYPE, new GoFaqEventHandler() {
			@Override
			public void onGoFaq(GoFaqEvent event) {
				doOpenPage(PageConstants.FAQ);
			}
		});
		
		eventBus.addHandler(GoGalleryBuildEvent.TYPE, new GoGalleryBuildEventHandler() {
			@Override
			public void onGoGalleryBuild(GoGalleryBuildEvent event) {
				doOpenPage(PageConstants.GALLERY_BUILD);
			}
		});
		
		eventBus.addHandler(GoGalleryRoomEvent.TYPE, new GoGalleryRoomEventHandler() {
			@Override
			public void onGoGalleryRoom(GoGalleryRoomEvent event) {
				doOpenPage(PageConstants.GALLERY_ROOM);
			}
		});
		
		eventBus.addHandler(GoRegulationsEvent.TYPE, new GoRegulationsEventHandler() {
			@Override
			public void onGoRegulations(GoRegulationsEvent event) {
				doOpenPage(PageConstants.REGULATIONS);
			}
		});
		
		eventBus.addHandler(GoReservationEvent.TYPE, new GoReservationEventHandler() {
			@Override
			public void onGoReservation(GoReservationEvent event) {
				doOpenPage(PageConstants.RESERVATION);
			}
		});
		
		eventBus.addHandler(GoRoomEvent.TYPE, new GoRoomEventHandler() {
			@Override
			public void onGoRoom(GoRoomEvent event) {
				doOpenPage(PageConstants.ROOM);;
			}
		});
		
		eventBus.addHandler(GoStudioEvent.TYPE, new GoStudioEventHandler() {
			@Override
			public void onGoStudio(GoStudioEvent event) {
				doOpenPage(PageConstants.STUDIO);
			}
		});
		
		eventBus.addHandler(GoContactOKEvent.TYPE, new GoContactOKEventHandler(){
			@Override
			public void onGoContactOK(GoContactOKEvent event) {
				doOpenPage(PageConstants.CONTACT_OK);
			}
		});
		
		eventBus.addHandler(GoContactFailedEvent.TYPE, new GoContactFailedEventHandler() {
			@Override
			public void onGoContactFailed(GoContactFailedEvent event) {
				doOpenPage(PageConstants.CONTACT_FAILED);
			}
		});
		
		eventBus.addHandler(GoReservationOKEvent.TYPE, new GoReservationOKEventHandler(){

			@Override
			public void onGoReservationOK(GoReservationOKEvent event) {
				doOpenPage(PageConstants.RESERVATION_OK);
			}
	
		});
		
		eventBus.addHandler(GoReservationFailedEvent.TYPE, new GoReservationFailedEventHandler() {
			@Override
			public void onGoReservationFailed(GoReservationFailedEvent event) {
				doOpenPage(PageConstants.RESERVATION_FAILED);				
			}
		});

		eventBus.addHandler(GoAdminEvent.TYPE, new GoAdminEventHandler() {
			@Override
			public void onGoAdmin(GoAdminEvent event) {
				doOpenPage(PageConstants.ADMIN);
			}
		});
	}
	
	private void doOpenPage(String page) {
		History.newItem(page);
	}

	public void go(final HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem(PageConstants.HOME);
		} else {
			History.fireCurrentHistoryState();
		}
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			if (token.equals(PageConstants.HOME)) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						// lazily initialize our views, and keep them around to be reused
						//
						if (homeView == null) {
							homeView = new HomeViewImpl();

						}
						new BaduuumPresenter(eventBus, homeView).go(container);
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
			} else if (token.equals(PageConstants.PRICES) ) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (pricesView == null) {
							pricesView = new PricesViewImpl();
						}
						new BaduuumPresenter(eventBus, pricesView).go(container);
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
			} else if (token.equals(PageConstants.CALENDAR)) {
				GWT.runAsync( new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (calendarView == null){
							calendarView = new CalendarViewImpl();
						}
						new BaduuumPresenter(eventBus, calendarView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.ROOM)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (roomView == null){
							roomView = new RoomViewImpl();
						}
						new BaduuumPresenter(eventBus, roomView).go(container);;
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.RESERVATION)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (reservationView == null){
							reservationView = new ReservationViewImpl();
						}
						new BaduuumPresenter(eventBus, reservationView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.STUDIO)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (studioView == null){
							studioView = new StudioViewImpl();
						}
						new BaduuumPresenter(eventBus, studioView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.GALLERY_BUILD)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (galleryBuildView == null){
							galleryBuildView = new GalleryBuildViewImpl();
						}
						new BaduuumPresenter(eventBus, galleryBuildView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.GALLERY_ROOM)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (galleryRoomView == null){
							galleryRoomView = new GalleryRoomViewImpl();
						}
						new BaduuumPresenter(eventBus, galleryRoomView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.REGULATIONS)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (regulationsView == null){
							regulationsView = new RegulationsViewImpl();
						}
						new BaduuumPresenter(eventBus, regulationsView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.FAQ)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (faqView == null){
							faqView = new FaqViewImpl();
						}
						new BaduuumPresenter(eventBus, faqView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.CONTACT)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (contactView == null){
							contactView = new ContactViewImpl();
						}
						new BaduuumPresenter(eventBus, contactView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.CONTACT_OK)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (contactOKView == null){
							contactOKView = new ContactOKViewImpl();
						}
						new BaduuumPresenter(eventBus, contactOKView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.CONTACT_FAILED)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (contactFailedView == null){
							contactFailedView = new ContactFailedViewImpl();
						}
						new BaduuumPresenter(eventBus, contactFailedView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.RESERVATION_OK)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (reservationOKView == null){
							reservationOKView = new ReservationOKViewImpl();
						}
						new BaduuumPresenter(eventBus, reservationOKView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.RESERVATION_FAILED)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (reservationFailedView == null){
							reservationFailedView = new ReservationFailedViewImpl();
						}
						new BaduuumPresenter(eventBus, reservationFailedView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.ADMIN)){
				GWT.runAsync(new RunAsyncCallback() {

					@Override
					public void onSuccess() {
						if (adminView == null){
							adminView = new AdminViewImpl();
						}
						new BaduuumPresenter(eventBus, adminView).go(container);
					}

					@Override
					public void onFailure(Throwable reason) {
					}
				});
			}
		}
	}
}

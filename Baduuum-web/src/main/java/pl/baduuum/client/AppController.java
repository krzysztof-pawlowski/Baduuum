package pl.baduuum.client;

import pl.baduuum.PageConstants;
import pl.baduuum.client.event.GoCalendarEvent;
import pl.baduuum.client.event.GoCalendarEventHandler;
import pl.baduuum.client.event.GoContactEvent;
import pl.baduuum.client.event.GoContactEventHandler;
import pl.baduuum.client.event.GoContactFailedEvent;
import pl.baduuum.client.event.GoContactFailedEventHandler;
import pl.baduuum.client.event.GoContactOKEvent;
import pl.baduuum.client.event.GoContactOKEventHandler;
import pl.baduuum.client.event.GoFaqEvent;
import pl.baduuum.client.event.GoFaqEventHandler;
import pl.baduuum.client.event.GoGalleryBuildEvent;
import pl.baduuum.client.event.GoGalleryBuildEventHandler;
import pl.baduuum.client.event.GoGalleryRoomEvent;
import pl.baduuum.client.event.GoGalleryRoomEventHandler;
import pl.baduuum.client.event.GoHomeEvent;
import pl.baduuum.client.event.GoHomeEventHandler;
import pl.baduuum.client.event.GoPricesEvent;
import pl.baduuum.client.event.GoPricesEventHandler;
import pl.baduuum.client.event.GoRegulationsEvent;
import pl.baduuum.client.event.GoRegulationsEventHandler;
import pl.baduuum.client.event.GoReservationEvent;
import pl.baduuum.client.event.GoReservationEventHandler;
import pl.baduuum.client.event.GoRoomEvent;
import pl.baduuum.client.event.GoRoomEventHandler;
import pl.baduuum.client.event.GoStudioEvent;
import pl.baduuum.client.event.GoStudioEventHandler;
import pl.baduuum.client.presenter.BaduuumPresenter;
import pl.baduuum.client.presenter.Presenter;
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
	
	private HomeViewImpl baduuumHomeView = null;
	private PricesViewImpl baduuumPricesView = null;
	private CalendarViewImpl baduuumCalendarView = null;
	private RoomViewImpl baduuumRoomView = null;
	private StudioViewImpl studioViewImpl = null;
	private ReservationViewImpl baduuumReservationView = null;
	private GalleryRoomViewImpl baduuumGalleryRoomView = null;
	private GalleryBuildViewImpl baduuumGalleryBuildView = null;
	private RegulationsViewImpl baduuumRegulationsView = null;
	private FaqViewImpl baduuumFaqView = null;
	private ContactViewImpl baduuumContactView = null;
	private ContactOKViewImpl baduuumContactOKView = null;
	private ContactFailedViewImpl baduuumContactFailedView = null;
	

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
						if (baduuumHomeView == null) {
							baduuumHomeView = new HomeViewImpl();

						}
						new BaduuumPresenter(eventBus, baduuumHomeView).go(container);
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
			} else if (token.equals(PageConstants.PRICES) ) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumPricesView == null) {
							baduuumPricesView = new PricesViewImpl();
						}
						new BaduuumPresenter(eventBus, baduuumPricesView).go(container);
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
			} else if (token.equals(PageConstants.CALENDAR)) {
				GWT.runAsync( new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumCalendarView == null){
							baduuumCalendarView = new CalendarViewImpl();
						}
						new BaduuumPresenter(eventBus, baduuumCalendarView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.ROOM)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumRoomView == null){
							baduuumRoomView = new RoomViewImpl();
						}
						new BaduuumPresenter(eventBus, baduuumRoomView).go(container);;
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.RESERVATION)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumReservationView == null){
							baduuumReservationView = new ReservationViewImpl();
						}
						new BaduuumPresenter(eventBus, baduuumReservationView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.STUDIO)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (studioViewImpl == null){
							studioViewImpl = new StudioViewImpl();
						}
						new BaduuumPresenter(eventBus, studioViewImpl).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.GALLERY_BUILD)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumGalleryBuildView == null){
							baduuumGalleryBuildView = new GalleryBuildViewImpl();
						}
						new BaduuumPresenter(eventBus, baduuumGalleryBuildView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.GALLERY_ROOM)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumGalleryRoomView == null){
							baduuumGalleryRoomView = new GalleryRoomViewImpl();
						}
						new BaduuumPresenter(eventBus, baduuumGalleryRoomView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.REGULATIONS)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumRegulationsView == null){
							baduuumRegulationsView = new RegulationsViewImpl();
						}
						new BaduuumPresenter(eventBus, baduuumRegulationsView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.FAQ)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumFaqView == null){
							baduuumFaqView = new FaqViewImpl();
						}
						new BaduuumPresenter(eventBus, baduuumFaqView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.CONTACT)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumContactView == null){
							baduuumContactView = new ContactViewImpl();
						}
						new BaduuumPresenter(eventBus, baduuumContactView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.CONTACT_OK)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumContactOKView == null){
							baduuumContactOKView = new ContactOKViewImpl();
						}
						new BaduuumPresenter(eventBus, baduuumContactOKView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(PageConstants.CONTACT_FAILED)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumContactFailedView == null){
							baduuumContactFailedView = new ContactFailedViewImpl();
						}
						new BaduuumPresenter(eventBus, baduuumContactFailedView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			}
		}
	}
}

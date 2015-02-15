package pl.baduuum.client;

import pl.baduuum.client.event.GoCalendarEvent;
import pl.baduuum.client.event.GoCalendarEventHandler;
import pl.baduuum.client.event.GoContactEvent;
import pl.baduuum.client.event.GoContactEventHandler;
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
import pl.baduuum.client.presenter.BaduuumPresenter;
import pl.baduuum.client.presenter.Presenter;
import pl.baduuum.client.view.BaduuumCalendarViewImpl;
import pl.baduuum.client.view.BaduuumContactViewImpl;
import pl.baduuum.client.view.BaduuumFaqViewImpl;
import pl.baduuum.client.view.BaduuumGalleryBuildViewImpl;
import pl.baduuum.client.view.BaduuumGalleryRoomViewImpl;
import pl.baduuum.client.view.BaduuumHomeViewImpl;
import pl.baduuum.client.view.BaduuumPricesViewImpl;
import pl.baduuum.client.view.BaduuumRegulationsViewImpl;
import pl.baduuum.client.view.BaduuumReservationViewImpl;
import pl.baduuum.client.view.BaduuumRoomViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {
	private static final String ROOM = "room";
	private static final String RESERVATION = "reservation";
	private static final String REGULATIONS = "regulations";
	private static final String GALLERY_ROOM = "galleryRoom";
	private static final String GALLERY_BUILD = "galleryBuild";
	private static final String FAQ = "faq";
	private static final String CONTACT = "contact";
	private static final String CALENDAR = "calendar";
	private static final String PRICES = "prices";
	private static final String HOME = "home";
	
	private final HandlerManager eventBus;
	private final BaduuumServiceAsync rpcService;
	private HasWidgets container;
	
	private BaduuumHomeViewImpl baduuumHomeView = null;
	private BaduuumPricesViewImpl baduuumPricesView = null;
	private BaduuumCalendarViewImpl baduuumCalendarView = null;
	private BaduuumRoomViewImpl baduuumRoomView = null;
	private BaduuumReservationViewImpl baduuumReservationView = null;
	private BaduuumGalleryRoomViewImpl baduuumGalleryRoomView = null;
	private BaduuumGalleryBuildViewImpl baduuumGalleryBuildView = null;
	private BaduuumRegulationsViewImpl baduuumRegulationsView = null;
	private BaduuumFaqViewImpl baduuumFaqView = null;
	private BaduuumContactViewImpl baduuumContactView = null;
	

	public AppController(BaduuumServiceAsync rpcService, HandlerManager eventBus) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(GoHomeEvent.TYPE, new GoHomeEventHandler() {
			@Override
			public void onGoHome(GoHomeEvent event) {
				doOpenPage(HOME);
			}
		});

		eventBus.addHandler(GoPricesEvent.TYPE, new GoPricesEventHandler() {
			@Override
			public void onGoPrices(GoPricesEvent event) {
				doOpenPage(PRICES);
			}
		});
		
		eventBus.addHandler(GoCalendarEvent.TYPE, new GoCalendarEventHandler() {
			@Override
			public void onGoCalendar(GoCalendarEvent event) {
				doOpenPage(CALENDAR);
				
			}
		});
		
		eventBus.addHandler(GoContactEvent.TYPE, new GoContactEventHandler() {
			@Override
			public void onGoContact(GoContactEvent event) {
				doOpenPage(CONTACT);
			}
		});
		
		eventBus.addHandler(GoFaqEvent.TYPE, new GoFaqEventHandler() {
			@Override
			public void onGoFaq(GoFaqEvent event) {
				doOpenPage(FAQ);
			}
		});
		
		eventBus.addHandler(GoGalleryBuildEvent.TYPE, new GoGalleryBuildEventHandler() {
			@Override
			public void onGoGalleryBuild(GoGalleryBuildEvent event) {
				doOpenPage(GALLERY_BUILD);
			}
		});
		
		eventBus.addHandler(GoGalleryRoomEvent.TYPE, new GoGalleryRoomEventHandler() {
			@Override
			public void onGoGalleryRoom(GoGalleryRoomEvent event) {
				doOpenPage(GALLERY_ROOM);
			}
		});
		
		eventBus.addHandler(GoRegulationsEvent.TYPE, new GoRegulationsEventHandler() {
			@Override
			public void onGoRegulations(GoRegulationsEvent event) {
				doOpenPage(REGULATIONS);
			}
		});
		
		eventBus.addHandler(GoReservationEvent.TYPE, new GoReservationEventHandler() {
			@Override
			public void onGoReservation(GoReservationEvent event) {
				doOpenPage(RESERVATION);
			}
		});
		
		eventBus.addHandler(GoRoomEvent.TYPE, new GoRoomEventHandler() {
			@Override
			public void onGoRoom(GoRoomEvent event) {
				doOpenPage(ROOM);;
			}
		});
				

	}
	
	private void doOpenPage(String page) {
		History.newItem(page);
	}

	public void go(final HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem(HOME);
		} else {
			History.fireCurrentHistoryState();
		}
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			if (token.equals(HOME)) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						// lazily initialize our views, and keep them around to be reused
						//
						if (baduuumHomeView == null) {
							baduuumHomeView = new BaduuumHomeViewImpl();

						}
						new BaduuumPresenter(rpcService, eventBus, baduuumHomeView).go(container);
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
			} else if (token.equals(PRICES) ) {
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumPricesView == null) {
							baduuumPricesView = new BaduuumPricesViewImpl();
						}
						new BaduuumPresenter(rpcService, eventBus, baduuumPricesView).go(container);
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
			} else if (token.equals(CALENDAR)) {
				GWT.runAsync( new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumCalendarView == null){
							baduuumCalendarView = new BaduuumCalendarViewImpl();
						}
						new BaduuumPresenter(rpcService, eventBus, baduuumCalendarView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(ROOM)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumRoomView == null){
							baduuumRoomView = new BaduuumRoomViewImpl();
						}
						new BaduuumPresenter(rpcService, eventBus, baduuumRoomView).go(container);;
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(RESERVATION)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumReservationView == null){
							baduuumReservationView = new BaduuumReservationViewImpl();
						}
						new BaduuumPresenter(rpcService, eventBus, baduuumReservationView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(GALLERY_BUILD)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumGalleryBuildView == null){
							baduuumGalleryBuildView = new BaduuumGalleryBuildViewImpl();
						}
						new BaduuumPresenter(rpcService, eventBus, baduuumGalleryBuildView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(GALLERY_ROOM)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumGalleryRoomView == null){
							baduuumGalleryRoomView = new BaduuumGalleryRoomViewImpl();
						}
						new BaduuumPresenter(rpcService, eventBus, baduuumGalleryRoomView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(REGULATIONS)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumRegulationsView == null){
							baduuumRegulationsView = new BaduuumRegulationsViewImpl();
						}
						new BaduuumPresenter(rpcService, eventBus, baduuumRegulationsView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(FAQ)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumFaqView == null){
							baduuumFaqView = new BaduuumFaqViewImpl();
						}
						new BaduuumPresenter(rpcService, eventBus, baduuumFaqView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			} else if (token.equals(CONTACT)){
				GWT.runAsync(new RunAsyncCallback() {
					
					@Override
					public void onSuccess() {
						if (baduuumContactView == null){
							baduuumContactView = new BaduuumContactViewImpl();
						}
						new BaduuumPresenter(rpcService, eventBus, baduuumContactView).go(container);
					}
					
					@Override
					public void onFailure(Throwable reason) {
					}
				});
			}
			
		}
	}
}

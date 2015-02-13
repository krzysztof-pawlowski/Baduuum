package pl.baduuum.client.presenter;

import pl.baduuum.client.BaduuumServiceAsync;
import pl.baduuum.client.event.GoHomeEvent;
import pl.baduuum.client.event.GoPricesEvent;
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

	public void go(final HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
	}

	

}

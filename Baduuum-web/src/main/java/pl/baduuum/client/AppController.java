package pl.baduuum.client;

import pl.baduuum.client.event.GoHomeEvent;
import pl.baduuum.client.event.GoHomeEventHandler;
import pl.baduuum.client.event.GoPricesEvent;
import pl.baduuum.client.event.GoPricesEventHandler;
import pl.baduuum.client.presenter.BaduuumPresenter;
import pl.baduuum.client.presenter.Presenter;
import pl.baduuum.client.view.BaduuumHomeViewImpl;
import pl.baduuum.client.view.BaduuumPricesViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {
	private final HandlerManager eventBus;
	private final BaduuumServiceAsync rpcService;
	private HasWidgets container;
	private BaduuumHomeViewImpl baduuumHomeView = null;
	private BaduuumPricesViewImpl baduuumPricesView = null;

	public AppController(BaduuumServiceAsync rpcService, HandlerManager eventBus) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(GoHomeEvent.TYPE, new GoHomeEventHandler() {
			public void onGoHome(GoHomeEvent event) {
				doGoHome();
			}
		});

		eventBus.addHandler(GoPricesEvent.TYPE, new GoPricesEventHandler() {
			public void onGoPrices(GoPricesEvent event) {
				doGoPrices();
			}
		});

	}

	private void doGoHome() {
		History.newItem("home");
	}

	private void doGoPrices() {
		History.newItem("prices");
	}

	public void go(final HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem("home");
		} else {
			History.fireCurrentHistoryState();
		}
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			if (token.equals("home")) {
				GWT.runAsync(new RunAsyncCallback() {
					public void onFailure(Throwable caught) {
					}

					public void onSuccess() {
						// lazily initialize our views, and keep them around to be reused
						//
						if (baduuumHomeView == null) {
							baduuumHomeView = new BaduuumHomeViewImpl();

						}
						new BaduuumPresenter(rpcService, eventBus, baduuumHomeView).go(container);
					}
				});
			} else if (token.equals("prices") ) {
				GWT.runAsync(new RunAsyncCallback() {
					public void onFailure(Throwable caught) {
					}

					public void onSuccess() {
						if (baduuumPricesView == null) {
							baduuumPricesView = new BaduuumPricesViewImpl();
						}
						new BaduuumPresenter(rpcService, eventBus, baduuumPricesView).go(container);
					}
				});
			}
		}
	}
}

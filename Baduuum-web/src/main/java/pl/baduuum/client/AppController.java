package pl.baduuum.client;

import pl.baduuum.client.event.TestEvent;
import pl.baduuum.client.event.TestEventHandler;
import pl.baduuum.client.presenter.Presenter;
import pl.baduuum.client.presenter.TestPresenter;
import pl.baduuum.client.view.TestView;
import pl.baduuum.client.view.TestViewImpl;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {

	private final HandlerManager eventBus;
	private final BaduuumServiceAsync rpcService;
	private HasWidgets container;
	
	private TestViewImpl testView = null;


	public AppController(BaduuumServiceAsync rpcService, HandlerManager eventBus) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(TestEvent.TYPE, new TestEventHandler() {
			public void onAddContact(TestEvent event) {
				doAddNewContact();
			}
		});
	}

	public void go(final HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem("list");
		} else {
			History.fireCurrentHistoryState();
		}
	}

	private void doAddNewContact() {
		History.newItem("add", false);
		
		if (testView == null){
			testView = new TestViewImpl();
		}		
		
		Presenter presenter = new TestPresenter(rpcService, eventBus, testView);
		presenter.go(container);
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;

			if (token.equals("add")) {
				presenter = new TestPresenter(rpcService, eventBus, new TestView());
			}

			if (presenter != null) {
				presenter.go(container);
			}
		}
	}

}

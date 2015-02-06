package pl.baduuum.client.presenter;

import pl.baduuum.client.BaduuumServiceAsync;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class TestPresenter implements Presenter {

	public interface Display {
		HasClickHandlers getAddButton();

		Widget asWidget();
	}

	private BaduuumServiceAsync rpcService;
	private HandlerManager eventBus;
	private Display display;

	public TestPresenter(BaduuumServiceAsync rpcService, HandlerManager eventBus, Display display) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		bind();
	}

	private void bind() {
		// TODO Auto-generated method stub

	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub

	}

}

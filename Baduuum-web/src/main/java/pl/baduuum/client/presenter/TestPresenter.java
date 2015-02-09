package pl.baduuum.client.presenter;

import pl.baduuum.client.BaduuumServiceAsync;
import pl.baduuum.client.event.TestEvent;
import pl.baduuum.client.view.TestView;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class TestPresenter implements Presenter, TestView.Presenter {

	  private final BaduuumServiceAsync rpcService;
	  private final HandlerManager eventBus;
	  private final TestView view;
	  
	  public TestPresenter(BaduuumServiceAsync rpcService, HandlerManager eventBus, TestView view){
		  this.rpcService = rpcService;
		  this.eventBus = eventBus;
		  this.view = view;
		  this.view.setPresenter(this);
	  }

	@Override
	public void onAddButtonClicked() {
		eventBus.fireEvent(new TestEvent());
		
	}

	@Override
	public void go(HasWidgets container) {
	    container.clear();
	    container.add(view.asWidget());		
	}
	  
	  

}

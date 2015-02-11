package pl.baduuum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class BaduuumEntry  {

	public void onModuleLoad() {

		BaduuumServiceAsync rpcService = GWT.create(BaduuumService.class);
		HandlerManager eventBus = new HandlerManager(null);
		AppControllerOld appViewer = new AppControllerOld(rpcService, eventBus);
		appViewer.go(RootPanel.get());

	
	}

}

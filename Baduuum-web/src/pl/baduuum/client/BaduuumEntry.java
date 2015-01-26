package pl.baduuum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class BaduuumEntry implements EntryPoint{

	public void onModuleLoad() {
		RootPanel.get().add(new Baduuum());   
		
	}

}

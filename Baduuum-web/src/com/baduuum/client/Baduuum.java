package com.baduuum.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Baduuum extends Composite {
	
	private static BaduuumUiBinder uiBinder = GWT.create(BaduuumUiBinder.class);
	
	@UiField
	Label completionLabel1;

	@UiField
	Label completionLabel2;

	private BaduuumResources res;  
	
	@UiTemplate("Baduuum.ui.xml")
	interface LoginUiBinder extends UiBinder<Widget, Baduuum> {  }
	   
	public Baduuum() {
		   this.res = GWT.create(BaduuumResources.class);
		   res.style().ensureInjected();
		   initWidget(uiBinder.createAndBindUi(this));
		}
}

package com.baduuum.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface BaduuumResources extends ClientBundle {
	   public interface MyCss extends CssResource {
	      String blackText();

	      
	   }

	   @Source("Baduuum.css")
	   MyCss style();
	}

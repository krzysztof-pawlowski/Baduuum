package pl.baduuum.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface StyleResources extends ClientBundle {

	@Source("BaduuumStyles.css")
	Style style();

	public interface Style extends CssResource {
		String center();
	}
}

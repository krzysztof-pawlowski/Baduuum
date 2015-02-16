package pl.baduuum.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface BaduuumResources extends ClientBundle {

	@Source("BaduuumStyles.css")
	Style style();

	@Source("images/logo.jpg")
	ImageResource logo();

	public interface Style extends CssResource {
		String center();
	}
}

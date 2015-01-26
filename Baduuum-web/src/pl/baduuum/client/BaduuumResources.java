package pl.baduuum.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface BaduuumResources extends ClientBundle {

	public interface MyCss extends CssResource {
		String blackText();

		String redText();

		String loginButton();

		String box();

		String background();
		
		String footer();
		
		String header();
		
		String wrapper();
		
		String content();

	}

	@Source("Baduuum.css")
	MyCss style();
}


package pl.baduuum.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ImageResources extends ClientBundle {
	
	@Source("images/logo.jpg")
	ImageResource logo();
	
	@Source("images//gallery//room/DSC_3526.jpg")
	ImageResource homePage1();
	
	@Source("images/gallery/room/DSC_1651.jpg")
	ImageResource homePage2();
	
	@Source("images/gallery/room/DSC_3022.jpg")
	ImageResource homePage3(); 
	
}

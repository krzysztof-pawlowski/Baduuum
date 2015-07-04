package pl.baduuum.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ImageResources extends ClientBundle {
	
	@Source("images/logo.jpg")
	ImageResource logo();
	
	// home page 
	@Source("images/gallery/room/DSC_3526_tn.jpg")
	ImageResource homePage1();
	
	@Source("images/gallery/room/DSC_1651_tn.jpg")
	ImageResource homePage2();
	
	@Source("images/gallery/room/DSC_3025_tn.jpg")
	ImageResource homePage3(); 
	
	
	// room page
	@Source("images/gallery/room/DSC_3541_tn.jpg")
	ImageResource roomPage1(); 
	
	@Source("images/gallery/room/DSC_3535.jpg")
	ImageResource roomPage2(); 
	
	@Source("images/gallery/room/DSC_3025.jpg")
	ImageResource roomPage3(); 
	
}

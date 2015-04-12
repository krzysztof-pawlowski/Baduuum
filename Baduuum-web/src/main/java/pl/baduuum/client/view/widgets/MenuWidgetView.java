package pl.baduuum.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MenuWidgetView extends Composite {
	
    @UiTemplate("MenuWidgetViewHome.ui.xml")
    interface MenuWidgetViewHomeUiBinder extends UiBinder<Widget, MenuWidgetView> {}
    
    @UiTemplate("MenuWidgetViewPrices.ui.xml")
    interface MenuWidgetViewPricesUiBinder extends UiBinder<Widget, MenuWidgetView> {}
    
    @UiTemplate("MenuWidgetViewCalendar.ui.xml")
    interface MenuWidgetViewCalendarUiBinder extends UiBinder<Widget, MenuWidgetView> {}
    
    @UiTemplate("MenuWidgetViewContact.ui.xml")
    interface MenuWidgetViewContactUiBinder extends UiBinder<Widget, MenuWidgetView> {}
    
    @UiTemplate("MenuWidgetViewFaq.ui.xml")
    interface MenuWidgetViewFaqUiBinder extends UiBinder<Widget, MenuWidgetView> {}

    @UiTemplate("MenuWidgetViewGallery.ui.xml")
    interface MenuWidgetViewGalleryUiBinder extends UiBinder<Widget, MenuWidgetView> {}
    
    @UiTemplate("MenuWidgetViewRegulations.ui.xml")
    interface MenuWidgetViewRegulationsUiBinder extends UiBinder<Widget, MenuWidgetView> {}
    
    @UiTemplate("MenuWidgetViewReservation.ui.xml")
    interface MenuWidgetViewReservationUiBinder extends UiBinder<Widget, MenuWidgetView> {}
    
    @UiTemplate("MenuWidgetViewRoom.ui.xml")
    interface MenuWidgetViewRoomUiBinder extends UiBinder<Widget, MenuWidgetView> {}
    
    @UiTemplate("MenuWidgetViewStudio.ui.xml")
    interface MenuWidgetViewStudioUiBinder extends UiBinder<Widget, MenuWidgetView> {}
    
    
    private static UiBinder<Widget, MenuWidgetView> uiBinder;

    @UiConstructor
    public MenuWidgetView(final String activeMenuItem) {
    	
    	if (activeMenuItem.equals("home")){
    		uiBinder = GWT.create(MenuWidgetViewHomeUiBinder.class);
    	} else if (activeMenuItem.equals("prices")){
    		uiBinder = GWT.create(MenuWidgetViewPricesUiBinder.class);
    	} else if (activeMenuItem.equals("calendar")){
    		uiBinder = GWT.create(MenuWidgetViewCalendarUiBinder.class);
    	} else if (activeMenuItem.equals("contact")){
    		uiBinder = GWT.create(MenuWidgetViewContactUiBinder.class);
    	} else if (activeMenuItem.equals("faq")){
    		uiBinder = GWT.create(MenuWidgetViewFaqUiBinder.class);
    	} else if (activeMenuItem.equals("gallery")){
    		uiBinder = GWT.create(MenuWidgetViewGalleryUiBinder.class);
    	} else if (activeMenuItem.equals("regulations")){
    		uiBinder = GWT.create(MenuWidgetViewRegulationsUiBinder.class);
    	} else if (activeMenuItem.equals("reservation")){ 
    		uiBinder = GWT.create(MenuWidgetViewReservationUiBinder.class);
    	} else if (activeMenuItem.equals("room")){
    		uiBinder = GWT.create(MenuWidgetViewRoomUiBinder.class);
    	} else if (activeMenuItem.equals("studio")){
    		uiBinder = GWT.create(MenuWidgetViewStudioUiBinder.class);
    	}
    		
        initWidget(uiBinder.createAndBindUi(this));
    }
    
  public MenuWidgetView() {
    	
   		uiBinder = GWT.create(MenuWidgetViewHomeUiBinder.class);
        initWidget(uiBinder.createAndBindUi(this));
    }


}

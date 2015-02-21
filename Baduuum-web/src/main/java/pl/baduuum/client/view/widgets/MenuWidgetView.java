package pl.baduuum.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MenuWidgetView extends Composite {
	
    @UiTemplate("MenuWidgetView.ui.xml")
    interface MenuWidgetViewUiBinder extends UiBinder<Widget, MenuWidgetView> {    }
    
    private static MenuWidgetViewUiBinder uiBinder = GWT.create(MenuWidgetViewUiBinder.class);

    public MenuWidgetView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}

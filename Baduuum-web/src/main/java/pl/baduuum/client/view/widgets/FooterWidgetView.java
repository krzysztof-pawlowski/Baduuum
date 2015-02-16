package pl.baduuum.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FooterWidgetView extends Composite {

    @UiTemplate("FooterWidgetView.ui.xml")
    interface FooterWidgetViewUiBinder extends UiBinder<Widget, FooterWidgetView> {    }
    
    private static FooterWidgetViewUiBinder uiBinder = GWT.create(FooterWidgetViewUiBinder.class);

    public FooterWidgetView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
package pl.baduuum.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HeaderWidgetView extends Composite {

    @UiTemplate("HeaderWidgetView.ui.xml")
    interface HeaderWidgetViewUiBinder extends UiBinder<Widget, HeaderWidgetView> {    }
    
    private static HeaderWidgetViewUiBinder uiBinder = GWT.create(HeaderWidgetViewUiBinder.class);

    public HeaderWidgetView() {
        initWidget(uiBinder.createAndBindUi(this));
    }
 }
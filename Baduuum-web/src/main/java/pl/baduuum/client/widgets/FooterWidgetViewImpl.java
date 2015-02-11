package pl.baduuum.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FooterWidgetViewImpl extends Composite {

    @UiTemplate("FooterWidgetView.ui.xml")
    interface FooterWidgetViewUiBinder extends UiBinder<Widget, FooterWidgetViewImpl> {    }
    
    private static FooterWidgetViewUiBinder uiBinder = GWT.create(FooterWidgetViewUiBinder.class);

    @UiField Label displayText;
    
    public void setMyField(String t) {
        displayText.setText(t);
    }

    public FooterWidgetViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
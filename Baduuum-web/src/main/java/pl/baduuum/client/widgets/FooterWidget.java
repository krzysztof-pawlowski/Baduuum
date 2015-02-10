package pl.baduuum.client.widgets;

import com.google.gwt.core.client.GWT;  
import com.google.gwt.uibinder.client.UiBinder;  
import com.google.gwt.uibinder.client.UiField;  
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;  
import com.google.gwt.user.client.ui.Label;  
import com.google.gwt.user.client.ui.Widget;

public class FooterWidget extends Composite {

    private static SomeWidgetUiBinder uiBinder = GWT.create(SomeWidgetUiBinder.class);

    @UiTemplate("FooterWidget.ui.xml")
    interface SomeWidgetUiBinder extends UiBinder<Widget, FooterWidget> {    }

    @UiField Label displayText;

    public void setMyField(String t) {
        displayText.setText(t);
    }

    public FooterWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
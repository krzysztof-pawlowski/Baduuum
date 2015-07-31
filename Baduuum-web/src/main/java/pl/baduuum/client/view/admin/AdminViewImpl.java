package pl.baduuum.client.view.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import pl.baduuum.client.view.BaduuumView;

/**
 * Created by Mariusz.Pawlowski on 2015-07-31.
 */
public class AdminViewImpl extends Composite implements BaduuumView {

    @UiTemplate("AdminView.ui.xml")
    interface BaduuumAdminViewUiBinder extends UiBinder<Widget, AdminViewImpl> {
    }

    private static BaduuumAdminViewUiBinder uiBinder = GWT.create(BaduuumAdminViewUiBinder.class);


    public AdminViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public Widget asWidget() {
        return this;
    }

}
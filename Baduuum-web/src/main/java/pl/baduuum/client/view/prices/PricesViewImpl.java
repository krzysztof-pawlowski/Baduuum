package pl.baduuum.client.view.prices;

import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class PricesViewImpl extends Composite implements BaduuumView{

	@UiTemplate("PricesView.ui.xml")
	interface BaduuumPricesViewUiBinder extends UiBinder<Widget, PricesViewImpl> {
	}

	private static BaduuumPricesViewUiBinder uiBinder = GWT.create(BaduuumPricesViewUiBinder.class);

	public PricesViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public Widget asWidget() {
		return this;
	}
}

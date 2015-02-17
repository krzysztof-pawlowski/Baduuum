package pl.baduuum.client.view.prices;

import pl.baduuum.client.view.BaduuumView;
import pl.baduuum.client.view.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class PricesViewImpl extends BaseView implements BaduuumView{

	@UiTemplate("PricesView.ui.xml")
	interface BaduuumPricesViewUiBinder extends UiBinder<Widget, PricesViewImpl> {
	}

	private static BaduuumPricesViewUiBinder uiBinder = GWT.create(BaduuumPricesViewUiBinder.class);

	private Presenter presenter;

	public PricesViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	public Widget asWidget() {
		return this;
	}

	@Override
	public void initializeMenu() {
		setCommands(presenter);
	}

}
package pl.baduuum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumPricesViewImpl extends BaseView implements BaduuumView{

	@UiTemplate("BaduuumPricesView.ui.xml")
	interface BaduuumPricesViewUiBinder extends UiBinder<Widget, BaduuumPricesViewImpl> {
	}

	private static BaduuumPricesViewUiBinder uiBinder = GWT.create(BaduuumPricesViewUiBinder.class);

	private Presenter presenter;

	public BaduuumPricesViewImpl() {
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

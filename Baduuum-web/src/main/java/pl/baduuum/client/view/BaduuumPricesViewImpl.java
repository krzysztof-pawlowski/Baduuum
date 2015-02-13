package pl.baduuum.client.view;

import pl.baduuum.client.view.BaduuumView.Presenter;
import pl.baduuum.client.view.BaduuumHomeViewImpl.BaduuumHomeViewUiBinder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumPricesViewImpl extends Composite implements BaduuumView{

	@UiTemplate("BaduuumPricesView.ui.xml")
	interface BaduuumPricesViewUiBinder extends UiBinder<Widget, BaduuumPricesViewImpl> {
	}

	private static BaduuumPricesViewUiBinder uiBinder = GWT.create(BaduuumPricesViewUiBinder.class);

	@UiField
	MenuItem buttonHome;
	
	@UiField 
	MenuItem buttonPrice;

	private Presenter presenter;

	public BaduuumPricesViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));

		Command homeCommand = new Command() {
			@Override
			public void execute() {
				if (presenter != null) {
					presenter.onHomeButtonClicked();
				}
			}
		};
		
		Command pricesCommand = new Command() {
			@Override
			public void execute() {
				if (presenter != null) {
					presenter.onPricesButtonClicked();
				}
			}
		};

		buttonHome.setScheduledCommand(homeCommand);
		buttonPrice.setScheduledCommand(pricesCommand);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	public Widget asWidget() {
		return this;
	}

	@Override
	public void initializeMenu() {
		// TODO Auto-generated method stub
		
	}

}

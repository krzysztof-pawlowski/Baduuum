package pl.baduuum.client.view;

import pl.baduuum.client.view.shared.MenuCommandsPreparer;
import pl.baduuum.client.view.shared.PricesCommand;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumHomeViewImpl extends Composite implements BaduuumView {

	@UiTemplate("BaduuumHomeView.ui.xml")
	interface BaduuumHomeViewUiBinder extends UiBinder<Widget, BaduuumHomeViewImpl> {
	}

	private static BaduuumHomeViewUiBinder uiBinder = GWT.create(BaduuumHomeViewUiBinder.class);

	@UiField
	MenuItem buttonHome;
	
	@UiField 
	MenuItem buttonPrice;

	private Presenter presenter;

	public BaduuumHomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		MenuCommandsPreparer menuCommandsPreparer = new MenuCommandsPreparer(presenter);

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
		buttonPrice.setScheduledCommand(new PricesCommand(presenter));
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	public Widget asWidget() {
		return this;
	}
}

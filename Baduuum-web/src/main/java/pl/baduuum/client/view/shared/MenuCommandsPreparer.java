package pl.baduuum.client.view.shared;

import pl.baduuum.client.view.BaduuumView.Presenter;

import com.google.gwt.user.client.Command;

public class MenuCommandsPreparer {
	
	private Presenter presenter;

	public MenuCommandsPreparer(Presenter presenter) {
		this.presenter = presenter;
	}
	
	public Command getHomeCommand(){
		Command homeCommand = new Command() {
			@Override
			public void execute() {
				if (presenter != null) {
					presenter.onHomeButtonClicked();
				}
			}
		};
		
		return homeCommand;
	}
	
	public Command getPricesCommand(){
		Command pricesCommand = new Command() {
			@Override
			public void execute() {
				if (presenter != null) {
					presenter.onPricesButtonClicked();
				}
			}
		};
		
		return pricesCommand;
	}
	

}

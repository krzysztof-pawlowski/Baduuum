package pl.baduuum.client.view.commands;

import pl.baduuum.client.view.BaduuumView.Presenter;
import com.google.gwt.user.client.Command;

public class PricesCommand implements Command {

	private Presenter presenter;
	public PricesCommand(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void execute() {
		if (presenter != null) {
			presenter.onPricesButtonClicked();
		}
	}
}

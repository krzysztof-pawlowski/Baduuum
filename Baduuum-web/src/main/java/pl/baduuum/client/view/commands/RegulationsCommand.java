package pl.baduuum.client.view.commands;

import pl.baduuum.client.view.BaduuumView.Presenter;
import com.google.gwt.user.client.Command;

public class RegulationsCommand implements Command{

	private Presenter presenter;
	
	public RegulationsCommand(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void execute() {
		if (presenter != null) {
			presenter.onRegulationsButtonClicked();
		}	
	}

}

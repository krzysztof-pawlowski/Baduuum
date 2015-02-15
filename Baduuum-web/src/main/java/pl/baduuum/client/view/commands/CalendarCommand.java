package pl.baduuum.client.view.commands;

import pl.baduuum.client.view.BaduuumView.Presenter;
import com.google.gwt.user.client.Command;

public class CalendarCommand implements Command{

	private Presenter presenter;
	
	public CalendarCommand(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void execute() {
		if (presenter != null) {
			presenter.onCalendarButtonClicked();
		}
	}

}

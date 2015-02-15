package pl.baduuum.client.view.commands;

import pl.baduuum.client.view.BaduuumView.Presenter;
import com.google.gwt.user.client.Command;

public class GalleryBuildCommand implements Command{

	private Presenter presenter;
	
	public GalleryBuildCommand(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void execute() {
		if (presenter != null) {
			presenter.onGalleryBuildButtonClicked();
		}
	}

}

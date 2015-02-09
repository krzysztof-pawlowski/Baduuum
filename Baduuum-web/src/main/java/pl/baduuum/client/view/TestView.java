package pl.baduuum.client.view;

import com.google.gwt.user.client.ui.Widget;

public interface TestView  {
	
	public interface Presenter {
		void onAddButtonClicked();
	}
	
	void setPresenter(Presenter presenter);
	Widget asWidget();

}

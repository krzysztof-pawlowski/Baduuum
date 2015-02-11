package pl.baduuum.client.widgets;

import com.google.gwt.user.client.ui.Widget;

public interface FooterWidgetView {
	
	public interface Presenter {
	    void onTest();
	  }
	  void setPresenter(Presenter presenter);
	  Widget asWidget();

}

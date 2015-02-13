package pl.baduuum.client.view;

import com.google.gwt.user.client.ui.Widget;

public interface BaduuumView {

  public interface Presenter {
    void onHomeButtonClicked();
	void onPricesButtonClicked();
  }
  void setPresenter(Presenter presenter);
  Widget asWidget();
  void initializeMenu();
}

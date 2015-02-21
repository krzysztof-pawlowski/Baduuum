package pl.baduuum.client.view;

import com.google.gwt.user.client.ui.Widget;

public interface BaduuumView {

  public interface Presenter {
    void onHomeButtonClicked();
	void onPricesButtonClicked();
	void onCalendarButtonClicked();
	void onContactButtonClicked();
	void onFaqButtonClicked();
	void onGalleryBuildButtonClicked();
	void onGalleryRoomButtonClicked();
	void onRegulationsButtonClicked();
	void onReservationButtonClicked();
	void onRoomButtonClicked();
  }
  
  Widget asWidget();
}

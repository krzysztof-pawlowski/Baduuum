package pl.baduuum.client.view.calendar;

import pl.baduuum.client.view.BaduuumView;
import pl.baduuum.client.view.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class CalendarViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("CalendarView.ui.xml")
	interface BaduuumCalendarViewUiBinder extends UiBinder<Widget, CalendarViewImpl> {
	}

	private static BaduuumCalendarViewUiBinder uiBinder = GWT.create(BaduuumCalendarViewUiBinder.class);
	
	private Presenter presenter;

	public CalendarViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	public Widget asWidget() {
		return this;
	}

	@Override
	public void initializeMenu() {
		setCommands(presenter);
	}
}

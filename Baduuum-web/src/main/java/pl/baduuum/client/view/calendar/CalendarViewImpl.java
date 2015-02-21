package pl.baduuum.client.view.calendar;

import pl.baduuum.client.view.BaduuumView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CalendarViewImpl extends Composite implements BaduuumView {

	@UiTemplate("CalendarView.ui.xml")
	interface BaduuumCalendarViewUiBinder extends UiBinder<Widget, CalendarViewImpl> {
	}

	private static BaduuumCalendarViewUiBinder uiBinder = GWT.create(BaduuumCalendarViewUiBinder.class);
	

	public CalendarViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));	
	}

	public Widget asWidget() {
		return this;
	}

}

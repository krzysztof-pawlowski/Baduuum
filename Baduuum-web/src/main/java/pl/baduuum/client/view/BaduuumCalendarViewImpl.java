package pl.baduuum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class BaduuumCalendarViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("BaduuumCalendarView.ui.xml")
	interface BaduuumCalendarViewUiBinder extends UiBinder<Widget, BaduuumCalendarViewImpl> {
	}

	private static BaduuumCalendarViewUiBinder uiBinder = GWT.create(BaduuumCalendarViewUiBinder.class);
	
	private Presenter presenter;

	public BaduuumCalendarViewImpl() {
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

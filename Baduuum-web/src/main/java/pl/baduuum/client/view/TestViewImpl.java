package pl.baduuum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TestViewImpl extends Composite implements TestView {

	@UiTemplate("TestView.ui.xml")
	interface TestViewUiBinder extends UiBinder<Widget, TestViewImpl> {
	}

	private static TestViewUiBinder uiBinder = GWT.create(TestViewUiBinder.class);

	@UiField
	Button addButton;

	private Presenter presenter;

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public TestViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("addButton")
	void onAddButtonClicked(ClickEvent event) {
		if (presenter != null) {
			presenter.onAddButtonClicked();
		}
	}

	public Widget asWidget() {
		return this;
	}
}

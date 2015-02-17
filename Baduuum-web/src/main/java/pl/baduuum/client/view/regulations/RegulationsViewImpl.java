package pl.baduuum.client.view.regulations;

import pl.baduuum.client.view.BaduuumView;
import pl.baduuum.client.view.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class RegulationsViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("RegulationsView.ui.xml")
	interface BaduuumRegulaionsViewUiBinder extends UiBinder<Widget, RegulationsViewImpl> {
	}

	private static BaduuumRegulaionsViewUiBinder uiBinder = GWT.create(BaduuumRegulaionsViewUiBinder.class);
	
	private Presenter presenter;

	public RegulationsViewImpl() {
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

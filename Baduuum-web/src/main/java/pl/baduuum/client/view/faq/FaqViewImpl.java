package pl.baduuum.client.view.faq;

import pl.baduuum.client.view.BaduuumView;
import pl.baduuum.client.view.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class FaqViewImpl extends BaseView implements BaduuumView {

	@UiTemplate("FaqView.ui.xml")
	interface BaduuumFaqViewUiBinder extends UiBinder<Widget, FaqViewImpl> {
	}

	private static BaduuumFaqViewUiBinder uiBinder = GWT.create(BaduuumFaqViewUiBinder.class);
	
	private Presenter presenter;

	public FaqViewImpl() {
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

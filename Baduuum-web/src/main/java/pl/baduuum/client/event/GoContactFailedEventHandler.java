package pl.baduuum.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface GoContactFailedEventHandler extends EventHandler {
	void onGoContactFailed(GoContactFailedEvent event);
}
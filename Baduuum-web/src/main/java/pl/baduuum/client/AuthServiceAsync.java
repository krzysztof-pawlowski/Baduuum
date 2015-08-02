package pl.baduuum.client;

/**
 * Created by mario on 01/08/15.
 */

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>AuthService</code>.
 */
public interface AuthServiceAsync {
    void retrieveUsername(AsyncCallback<String> callback);
}

package pl.baduuum.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by mario on 01/08/15.
 */
@RemoteServiceRelativePath("auth")
public interface AuthService extends RemoteService {
    String retrieveUsername();
}
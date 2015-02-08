package pl.baduuum.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("baduuumService")
public interface BaduuumService extends RemoteService {
  String greetServer(String name) throws IllegalArgumentException;
}

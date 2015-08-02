package pl.baduuum.server.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pl.baduuum.client.AuthService;

@SuppressWarnings("serial")
public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {

    @Override
    public String retrieveUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication==null){
            System.out.println("Not logged in");
            return null;
        }
        else {
            return (String) authentication.getPrincipal();
        }

    }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author danida
 */
import Entities.User;
import Facades.UserFacade;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.security.auth.login.LoginException;

@ManagedBean
@Stateless

public class Authenticator {

    @Inject
     UserFacade userfacade;

    private static Authenticator authenticator = null;


    // An authentication token storage which stores <service_key, auth_token>.
    private static Map<String, String> authorizationTokensStorage = new HashMap();

    public Authenticator() {
    }

    public static Authenticator getInstance() {
        if (authenticator == null) {
            authenticator = new Authenticator();
        }

        return authenticator;
    }

    public String login(String username, String password) throws LoginException {
        String storedPassword = userfacade.findByUsername(username).getPassword();
        

            if (storedPassword != null && storedPassword.equals(password) ) {

                /**
                 * Once all params are matched, the authToken will be generated
                 * and will be stored in the authorizationTokensStorage. The
                 * authToken will be needed for every REST API invocation and is
                 * only valid within the login session
                 */
                String authToken = UUID.randomUUID().toString();
                authorizationTokensStorage.put(authToken, username);

                return authToken;
            }
        

        throw new LoginException("Don't Come Here Again!");
    }

    /**
     * The method that pre-validates if the client which invokes the REST API is
     * from a authorized and authenticated source.
     *
     * @param authToken The authorization token generated after login
     * @return TRUE for acceptance and FALSE for denied.
     */
    public boolean isAuthTokenValid(String authToken) {

        if (authorizationTokensStorage.containsKey(authToken)) {
            return true;

        }

        return false;
    }

    public void logout(String authToken) throws GeneralSecurityException {

        if (authorizationTokensStorage.containsKey(authToken)) {

            /**
             * When a client logs out, the authentication token will be remove
             * and will be made invalid.
             */
            authorizationTokensStorage.remove(authToken);
            return;

        }

        throw new GeneralSecurityException("Invalid service key and authorization token match.");
    }

    public static Map<String, String> getAuthorizationTokensStorage() {
        return authorizationTokensStorage;
    }
    
    
}

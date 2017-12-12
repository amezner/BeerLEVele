/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Entities.User;
import Exceptions.AuthorizationFailedException;
import Exceptions.NoSuchAUserException;
import Facades.UserFacade;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 *
 * @author danida
 */
@ManagedBean
@Stateless

public class Authorizator {

    @Inject
    UserFacade userfacade;

    private static Authorizator authorizator = null;
    private Map<String, Integer> roles = new HashMap<String, Integer>();

    @PostConstruct
    public void init() {
        roles.put("admin", 100);
        roles.put("finance", 50);
        roles.put("operator", 1);

    }

    public Authorizator() {

    }

    public static Authorizator getInstance() {
        if (authorizator == null) {
            authorizator = new Authorizator();
        }

        return authorizator;

    }

    public boolean checkAuthorization(String authToken, String requirement) throws Exception {

        if (Authenticator.getAuthorizationTokensStorage().containsKey(authToken)) {
            String username = Authenticator.getAuthorizationTokensStorage().get(authToken);
            User user = userfacade.findByUsername(username);
            if (roles.get(user.getRole().toLowerCase()) >= roles.get(requirement)) {
                return true;
            }
        }

        throw new AuthorizationFailedException("You are not authorized for this call!");

    }

    public Integer getUserID(String authToken) throws Exception {

        if (Authenticator.getAuthorizationTokensStorage().containsKey(authToken)) {
            String username = Authenticator.getAuthorizationTokensStorage().get(authToken);
            User user = userfacade.findByUsername(username);
            return user.getId();
        }

        throw new AuthorizationFailedException("You are not authorized for this call!");

    }

    public String getPrivilege(String username) throws NoSuchAUserException {
        User user = userfacade.findByUsername(username);
        return user.getRole().toLowerCase();
        
    }

}

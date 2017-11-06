/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Entities.User;
import Facades.UserFacade;
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

    
    
    enum Roles {
        customer, admin, operator
    }

        private static Authorizator authorizator = null;

    
    
    public Authorizator() {
    }
    

    public static Authorizator getInstance() {
        if (authorizator == null) {
            authorizator = new Authorizator();
        }

        return authorizator;
    }

    public  boolean checkAuthorization(String authToken,String requirement) throws Exception {

        if (Authenticator.getAuthorizationTokensStorage().containsKey(authToken)) {
            String username = Authenticator.getAuthorizationTokensStorage().get(authToken);
            User user = userfacade.findByUsername(username);
            
            
            if(user.getRole().toLowerCase().equals(requirement)){
                return true;
            }

        }

        throw new Exception("You are not authorized for this call!");
    }

}

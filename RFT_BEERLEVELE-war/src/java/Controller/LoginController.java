/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.Authenticator;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.security.auth.login.LoginException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author danida
 */
@Stateless
@LocalBean
@Path("authentication")

public class LoginController {

    @EJB
    private Authenticator authenticator;

    @Path("login")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, String> login(Map <String,String> map) throws LoginException {
        
        String token = authenticator.login(map.get("username"), map.get("password"));
        Map<String, String> tok = new HashMap<String, String>();
        tok.put("username", map.get("username"));
        tok.put("token", token);
        return tok;
        
    }

    @Path("logout")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, String> logout(Map <String,String> map) throws GeneralSecurityException {
        
        authenticator.logout(map.get("authtoken"));
        Map<String, String> tok = new HashMap<>();
        tok.put("message", "Logout was successful");
        return tok;
    
    }
}

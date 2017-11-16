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
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    @Produces({"application/json"})
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, String> login(Map <String,String> map) throws LoginException {
        Logger logger = LoggerFactory.getLogger(LoginController.class);
        logger.debug("User is trying to login Username: " + map.get("username") + "\nPassword: " + map.get("password") + "\n");
        System.out.println(map);
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

    public String logout(@HeaderParam("authToken") String token) throws GeneralSecurityException {
        return authenticator.logout(token);

    }
}

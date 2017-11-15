/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Facades.CustomerFacade;
import Helper.Authenticator;
import java.security.GeneralSecurityException;
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
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public String[] login(@FormParam("username") String username, @FormParam("password") String password) throws LoginException {
 Logger logger = LoggerFactory.getLogger(LoginController.class);
        logger.debug("User is trying to login Username: "+username+"\nPassword: "+password+"\n");
        String token = authenticator.login(username, password);
        String[] tok = new String[2];
        tok[0] = username;
        tok[1] = token;
        return tok;

    }

    @Path("logout")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)

    public void logout(@HeaderParam("authToken") String token) throws GeneralSecurityException {
        authenticator.logout(token);

    }
}

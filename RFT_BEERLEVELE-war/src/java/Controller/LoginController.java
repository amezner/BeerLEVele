/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.Authenticator;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.security.auth.login.LoginException;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
    public String login(@FormParam("username") String username, @FormParam("password") String password) throws LoginException {
        return authenticator.login(username, password);

    }
}

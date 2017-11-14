/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.Authenticator;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.security.auth.login.LoginException;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.status;

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
    public Response login(@FormParam("username") String username, @FormParam("password") String password)  {
        try {
            return Response.status(200).entity(authenticator.login(username, password)).build();
        } catch (LoginException ex) {
            return Response.status(300).entity(ex.getMessage()).build(); 
        }
    }
    
    @Path("logout")
    @POST
    @Produces("application/json")
    public Response logout(@HeaderParam("authToken") String token) {
        try {
            return Response.status(200).entity(authenticator.logout(token)).build();   
        } catch (GeneralSecurityException ex) {
            return Response.status(Status.BAD_REQUEST).entity(ex.getMessage()).build(); 
        }
    }
}

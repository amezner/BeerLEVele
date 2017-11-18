/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.User;
import Helper.Authorizator;
import Helper.DataObjectMapper;
import Logic.UserLogic;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author danida
 */
@Stateless
@LocalBean
@Path("user")
public class UserController {

    @EJB
    private UserLogic userLogic;
    @EJB
    private Authorizator authorizator;

    @Path("saveuser")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveUser(@HeaderParam("authToken") String authToken, Map<String, String> map) throws Exception {

        authorizator.checkAuthorization(authToken, "admin");

        userLogic.insertUser(map.get("name"), map.get("role"), map.get("password"));

    }

    @Path("getalluser")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map getAll(@HeaderParam("authToken") String authToken) throws Exception {

        authorizator.checkAuthorization(authToken, "admin");
        
        DataObjectMapper<User> o = new DataObjectMapper<>(userLogic.findAllUser());
      
        return o.getMap();

    }

    @Path("deleteuser/{id}")
    @DELETE
    public void delete(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id) throws Exception {
        
        authorizator.checkAuthorization(authToken, "admin");
        
        userLogic.deleteUserById(id);

    }

    @Path("getuser/{id}")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map getUser(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id) throws Exception {
        
        authorizator.checkAuthorization(authToken, "admin");
        
        DataObjectMapper<User> o = new DataObjectMapper<>(userLogic.findUserById(id));
        
        return o.getMap();
    
    }
}

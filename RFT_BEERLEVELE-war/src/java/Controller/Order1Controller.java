/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Order1;
import Helper.Authenticator;
import Helper.Authorizator;
import Logic.Order1Logic;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dnovak
 */
@Stateless
@LocalBean
@Path("order")
public class Order1Controller {

    @EJB
    private Order1Logic order1logic;
    @EJB
    private Authorizator authorizator;

    @Path("getcart")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Order1> getAllFromCart(@HeaderParam("authToken") String authToken) throws Exception {
        authorizator.checkAuthorization(authToken, "admin");
        System.out.println(Authenticator.getAuthorizationTokensStorage().get(authToken));
        return order1logic.findAll(Authenticator.getAuthorizationTokensStorage().get(authToken));
    }

    @Path("putinthecart")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)

    public void putStockInCart(@HeaderParam("authToken") String authToken, @FormParam("stock_id") int stock_id, @FormParam("quantity") int quantity) throws Exception {
        authorizator.checkAuthorization(authToken, "admin");
        order1logic.insertInTheCart(authToken, stock_id, quantity);
    }

    @Path("deleteitemfromcart/{id}")
    @DELETE
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)

    public void deleteFromCart(@HeaderParam("authToken") String authToken, @PathParam("id") int id) throws Exception {
        authorizator.checkAuthorization(authToken, "admin");
        order1logic.deleteOrder1(id);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Order1;
import Helper.Authenticator;
import Helper.Authorizator;
import Helper.DataObjectMapper;
import Logic.Order1Logic;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
    public Map getAllFromCart(@HeaderParam("authToken") String authToken) throws Exception {
        
        authorizator.checkAuthorization(authToken, "admin");
        DataObjectMapper<Order1> o = new DataObjectMapper<>(order1logic.findCartByUid(authorizator.getUserID(authToken)));
        return o.getMap();

    }

    @Path("putinthecart")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putStockInCart(@HeaderParam("authToken") String authToken, Map<String, String> map) throws Exception {
        
        authorizator.checkAuthorization(authToken, "admin");
        order1logic.insertInTheCart(authorizator.getUserID(authToken), new Integer(map.get("stock_id")), new Integer(map.get("quantity")));

    }

    @Path("deleteitemfromcart/{stock_id}")
    @DELETE
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteFromCart(@HeaderParam("authToken") String authToken, @PathParam("stock_id") Integer stock_id) throws Exception {

        authorizator.checkAuthorization(authToken, "admin");
        order1logic.deleteOrder(authorizator.getUserID(authToken), stock_id);

    }

}

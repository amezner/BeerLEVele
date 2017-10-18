/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.CustomerBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author danida
 */
@Stateless
@LocalBean
@Path("Customer")

public class CustomerController {

    @EJB
    private CustomerBean customerBean;

    @Path("SaveCustomer")
    @GET
    @Produces("text/plain")
    public Response save(@QueryParam("name") String name, @QueryParam("address") String address, @QueryParam("email") String email, @QueryParam("phone") int phone, @QueryParam("loyalty") boolean loyaltycard, @QueryParam("discount") int discount) {
        try {
            customerBean.insertCustomer(name, address, email, phone, loyaltycard, discount);
        } catch (Exception ex) {
            return Response.status(0).build();
        }
        return Response.status(1).build();

    }

}

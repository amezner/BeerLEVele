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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
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
    @POST
    @Produces("text/plain")
    public void save(@FormParam("name") String name, @FormParam("address") String address, @FormParam("email") String email, @FormParam("phone") int phone, @FormParam("loyalty") boolean loyaltycard, @FormParam("discount") int discount) {
        try {
            customerBean.insertCustomer(name, address, email, phone, loyaltycard, discount);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

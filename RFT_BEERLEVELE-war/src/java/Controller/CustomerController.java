/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Logic.CustomerBean;
import Entities.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 *
 * @author danida
 */
@Stateless
@LocalBean
@Path("customer")

public class CustomerController {

    @EJB
    private CustomerBean customerBean;

    @Path("savecustomer")
    @POST
    @Produces("text/plain")
    public void save(@FormParam("name") String name, @FormParam("address") String address, @FormParam("email") String email, @FormParam("phone") int phone, @FormParam("loyalty") boolean loyaltycard, @FormParam("discount") int discount) {
        try {
            customerBean.insertCustomer(name, address, email, phone, loyaltycard, discount);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Path("getallcustomer")
    @GET
    @Produces("application/json")
    public List<Customer> save() {
        try {
            return customerBean.findAllCustomer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Path("deletecustomer/{id}")
    @DELETE
    public void save(@PathParam ("id") Integer id) {
        try {
            System.out.println(id);
            customerBean.deleteCustomerById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

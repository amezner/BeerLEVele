/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Logic.CustomerLogic;
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
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;

/**
 *
 * @author danida
 */
@Stateless
@LocalBean
@Path("customer")

public class CustomerController {

    @EJB
    private CustomerLogic customerLogic;

    @Path("savecustomer")
    @POST
    @Produces("text/plain")
    public void saveCustomer(@HeaderParam("authToken") String authToken,@FormParam("name") String name, @FormParam("address") String address, @FormParam("email") String email, @FormParam("phone") int phone, @FormParam("loyalty") boolean loyaltycard, @FormParam("discount") int discount) {
        System.out.println("adasdas" + authToken);
        try {
           
            customerLogic.insertCustomer(name, address, email, phone, loyaltycard, discount);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Path("getallcustomer")
    @GET
    @Produces("application/json")
    public List<Customer> getAll() {
        try {
            return customerLogic.findAllCustomer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Path("deletecustomer/{id}")
    @DELETE
    public void save(@PathParam ("id") Integer id) {
        try {
            customerLogic.deleteCustomerById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

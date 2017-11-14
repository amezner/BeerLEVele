/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Logic.CustomerLogic;
import Entities.Customer;
import Helper.Authorizator;
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
    private CustomerLogic customerLogic;
    @EJB
    private Authorizator authorizator;

    @Path("savecustomer")
    @POST
    @Produces("text/plain")
    public void saveCustomer(@HeaderParam("authToken") String authToken, @FormParam("name") String name, @FormParam("address") String address, @FormParam("email") String email, @FormParam("phone") String phone, @FormParam("loyalty") boolean loyaltycard, @FormParam("discount") int discount) throws Exception {
        authorizator.checkAuthorization(authToken, "admin");
        customerLogic.insertCustomer(name, address, email, phone, loyaltycard, discount);

    }

    @Path("getallcustomer")
    @GET
    @Produces("application/json")
    public List<Customer> getAll(@HeaderParam("authToken") String authToken) throws Exception {
        authorizator.checkAuthorization(authToken, "customer");
        return customerLogic.findAllCustomer();

    }

    @Path("deletecustomer/{id}")
    @DELETE
    public void save(@HeaderParam("authToken") String authToken,@PathParam("id") Integer id) throws Exception {
        authorizator.checkAuthorization(authToken, "admin");
        customerLogic.deleteCustomerById(id);

    }

    @Path("getcustomer")
    @GET
    public void getCustomer(@HeaderParam("authToken") String authToken,@QueryParam("id") int id) throws Exception {
        authorizator.checkAuthorization(authToken, "operator");
       
        customerLogic.findCustomerById(id);
    }

}

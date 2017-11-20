/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Logic.CustomerLogic;
import Entities.Customer;
import Helper.Authorizator;
import Helper.DataObjectMapper;
import Helper.Email;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

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
    @EJB
    private Email emailservice;

    @Path("savecustomer")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCustomer(@HeaderParam("authToken") String authToken, Map<String, String> map) throws Exception {

        authorizator.checkAuthorization(authToken, "admin");

        customerLogic.insertCustomer(map.get("name"), map.get("country"), map.get("city"), map.get("address"), map.get("postalcode"), map.get("email"), map.get("phone"), Boolean.parseBoolean(map.get("loyaltycard")), new Integer(map.get("discount")));

    }

    @Path("getallcustomer")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map getAll(@HeaderParam("authToken") String authToken) throws Exception {

        authorizator.checkAuthorization(authToken, "operator");

        DataObjectMapper<Customer> o = new DataObjectMapper<>(customerLogic.findAllCustomer());

        return o.getMap();

    }

    @Path("deletecustomer/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id) throws Exception {

        authorizator.checkAuthorization(authToken, "admin");

        customerLogic.deleteCustomerById(id);

    }

    @Path("getcustomer/{id}")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id) throws Exception {

        authorizator.checkAuthorization(authToken, "operator");

        DataObjectMapper<Customer> o = new DataObjectMapper<>(customerLogic.findCustomerById(id));

        return (Customer) o.getEntry();

    }

    @Path("sendemailto")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendEmail(@HeaderParam("authToken") String authToken, Map emaildetails) throws Exception {
        authorizator.checkAuthorization(authToken, "admin");
        String from = (String) emaildetails.get("from");
        String to = (String) emaildetails.get("to");
        String subject = (String) emaildetails.get("subject");
        String message = (String) emaildetails.get("message");
        String password = (String) emaildetails.get("password");

        emailservice.SendMail(from, to, password, subject, message);
    }

}

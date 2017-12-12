/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Logic.CustomerLogic;
import Entities.Customer;
import Exceptions.AuthorizationFailedException;
import Exceptions.NoSuchATokenException;
import Exceptions.NoSuchAUserException;
import Helper.Authorizator;
import Helper.DataObjectMapper;
import Helper.Email;
import java.util.List;
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
import javax.ws.rs.PUT;
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
    
    
    /**
     * 
     * @param authToken: A user tokenje.
     * @param customerdetails: Az ügyfél adatai.
     * @throws AuthorizationFailedException
     * @throws NoSuchAUserException
     * @throws NoSuchATokenException
     * @throws Exception 
     */

    @Path("savecustomer")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCustomer(@HeaderParam("authToken") String authToken, Map<String, String> customerdetails) throws AuthorizationFailedException, NoSuchAUserException, NoSuchATokenException, Exception  {
        
        authorizator.checkAuthorization(authToken, "admin");
        
        customerLogic.insertCustomer(customerdetails.get("name"), customerdetails.get("country"), customerdetails.get("city"), customerdetails.get("address"), customerdetails.get("postalcode"), customerdetails.get("email"), customerdetails.get("phone"), Boolean.parseBoolean(customerdetails.get("loyaltycard")), new Integer(customerdetails.get("discount")));
        
    }
    /**
     * @param authToken: A user tokenje.
     * @return : Visszaadja az összes customert. 
     * @throws Exception 
     */
    
    
    @Path("getallcustomer")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Customer> getAll(@HeaderParam("authToken") String authToken) throws Exception {
        
        authorizator.checkAuthorization(authToken, "operator");        
        
        
        return customerLogic.findAllCustomer();
        
    }
    
    /**
     * 
     * @param authToken: A user tokenje.
     * @param id: A törölni kívánt ügyfél id-ja.
     * @throws Exception 
     */
    
    @Path("deletecustomer/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id) throws Exception {
        
        authorizator.checkAuthorization(authToken, "admin");
        
        customerLogic.deleteCustomerById(id);
        
    }
    /**
     * 
     * @param authToken: A user tokenje.
     * @param id: Ügyfél id-ja.
     * @return Visszaadja a lekérdezett ügyfelet.
     * @throws Exception 
     */
    
    
    @Path("getcustomer/{id}")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id) throws Exception {
        
        authorizator.checkAuthorization(authToken, "operator");
        
        DataObjectMapper<Customer> o = new DataObjectMapper<>(customerLogic.findCustomerById(id));
        
        return (Customer) o.getEntry();
        
    }
    
    /**
     * 
     * @param authToken: A user tokenje.
     * @param id: Az ügyfél id-ja. 
     * @param customerdetails: Az ügyfél adatai.
     * @throws Exception 
     */
    
    @Path("editcustomer/{id}")
    @PUT
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editCustomer(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id, Map<String, String> customerdetails) throws Exception {
        
        authorizator.checkAuthorization(authToken, "operator");
        
        Customer cu = new Customer(customerdetails.get("name"), customerdetails.get("country"), customerdetails.get("city"), customerdetails.get("address"), customerdetails.get("postalcode"), customerdetails.get("email"), customerdetails.get("phone"), Boolean.parseBoolean(customerdetails.get("loyaltycard")), new Integer(customerdetails.get("discount")));
        cu.setId(id);
        
        customerLogic.editCustomer(cu);
        
    }
    
    /**
     * 
     * @param authToken: A user tokenje.
     * @param emaildetails: Az email küldéshez szükséges információk.
     * @throws Exception 
     */
    
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
    
    /**
     * 
     * @param authToken: A user tokenje.
     * @param filter: Az ügyfél neve amely alapján szűrni kell.
     * @return: Visszaadja az ügyfelek listáját, amely megfelel a feltételeknek.
     * @throws Exception 
     */
    
    @Path("filtercustomer/{filter}")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map filterCustomer(@HeaderParam("authToken") String authToken, @PathParam("filter") String filter) throws Exception {

        authorizator.checkAuthorization(authToken, "operator");
        DataObjectMapper<Customer> o = new DataObjectMapper<>(customerLogic.filterCustomerByName(filter));
      
        return o.getMap();

    }
    
}

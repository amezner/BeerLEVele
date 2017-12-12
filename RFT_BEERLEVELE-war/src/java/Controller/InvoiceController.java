/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Logic.InvoiceLogic;
import Entities.Invoice;
import Helper.Authorizator;
import Helper.DataObjectMapper;
import Helper.InvoiceWrapper;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ws.rs.Consumes;
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
@Path("invoice")

public class InvoiceController {

    @EJB
    private InvoiceLogic invoiceLogic;
    @EJB
    private Authorizator authorizator;

    /**
     * 
     * @param authToken: A user tokenje.
     * @param id: A számla id-ja
     * @return: Visszaadja a kiválasztott számlát.
     * @throws Exception 
     */
    
    @Path("getinvoice/{id}")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public InvoiceWrapper  getInvoice(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id) throws Exception {
        
        authorizator.checkAuthorization(authToken, "admin");
        DataObjectMapper<InvoiceWrapper> o = new DataObjectMapper<>(invoiceLogic.findInvoiceByInvoicenumber(id));

        return        (InvoiceWrapper) o.getEntry();
        
    }
    
    @Path("getallinvoices")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map getAll(@HeaderParam("authToken") String authToken) throws Exception {

        authorizator.checkAuthorization(authToken, "finance");

        Map ret = new HashMap<>();
        DataObjectMapper<Invoice> o = new DataObjectMapper<>(invoiceLogic.findAllInvoices());
      
        return o.getMap();

    }

    @Path("closeinvoice")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void closeInvoice(@HeaderParam("authToken") String authToken, Map<String, String> map) throws Exception {

        authorizator.checkAuthorization(authToken, "admin");

        invoiceLogic.closeInvoice(authorizator.getUserID(authToken), new Integer(map.get("customer_id")));

    }   
}

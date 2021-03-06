/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Logic.InvoiceLogic;
import Entities.Invoice;
import Helper.Authorizator;
import Helper.InvoiceWrapper;
import Helper.ProfitPerInvoice;
import Helper.StockConsumption;
import java.util.List;
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
    public InvoiceWrapper getInvoice(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id) throws Exception {

        authorizator.checkAuthorization(authToken, "admin");

        return invoiceLogic.findInvoiceByInvoicenumber(id);

    }

    @Path("getallinvoices")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Invoice> getAll(@HeaderParam("authToken") String authToken) throws Exception {

        authorizator.checkAuthorization(authToken, "finance");


        return invoiceLogic.findAllInvoices();

    }

    @Path("closeinvoice")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void closeInvoice(@HeaderParam("authToken") String authToken, Map<String, String> map) throws Exception {

        authorizator.checkAuthorization(authToken, "admin");

        invoiceLogic.closeInvoice(authorizator.getUserID(authToken), new Integer(map.get("customer_id")));

    }

    @Path("stockconsumptionpermonth")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<StockConsumption> stockConsumptionPerMonth(@HeaderParam("authToken") String authToken) throws Exception {

        authorizator.checkAuthorization(authToken, "finance");


        return invoiceLogic.stockConsumptionPerMonth();


    }
   
    @Path("stockconsumptionperstock/{id}")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<StockConsumption> stockConsumptionPerMonth(@HeaderParam("authToken") String authToken,@PathParam("id") Integer id) throws Exception {

        authorizator.checkAuthorization(authToken, "finance");


        return invoiceLogic.stockConsumptionPerStock(id);


    }

    @Path("profitperinvoice")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ProfitPerInvoice> profitPerInvoice(@HeaderParam("authToken") String authToken) throws Exception {

        authorizator.checkAuthorization(authToken, "finance");

        return invoiceLogic.profitPerInvoice();

    }

}

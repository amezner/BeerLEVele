/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Stock;
import Helper.Authorizator;
import Helper.DataObjectMapper;
import Logic.StockLogic;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
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
 * @author danida
 */
@Stateless
@LocalBean
@Path("stock")
public class StockController {

    @EJB
    private StockLogic stockLogic;
    @EJB
    private Authorizator authorizator;

    @Path("savestock")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveStock(@HeaderParam("authToken") String authToken, Map<String, String> map) throws Exception {

        authorizator.checkAuthorization(authToken, "admin");


        stockLogic.insertStock(map.get("name"), map.get("description"), map.get("type"), 5.2, 0.33, 450.0, 520.0, new Integer(map.get("onstockquantity")));
//        stockLogic.insertStock(map.get("name"), map.get("description"), map.get("type"), new Double(map.get("alcoholcontent")), new Double(map.get("bottlesize")), new Double(map.get("purcahaseprice")), new Double(map.get("sellingprice")), new Integer(map.get("onstockquantity")));

    }

    @Path("getallstock")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map getAll(@HeaderParam("authToken") String authToken) throws Exception {

        authorizator.checkAuthorization(authToken, "operator");
        
        DataObjectMapper<Stock> o = new DataObjectMapper<>(stockLogic.findAllStock());
      
        return o.getMap();

    }

    @Path("deletestock/{id}")
    @DELETE
    public void delete(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id) throws Exception {
        
        authorizator.checkAuthorization(authToken, "admin");
        
        stockLogic.deleteStockById(id);

    }

    @Path("getstock/{id}")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Stock getStock(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id) throws Exception {
        
        authorizator.checkAuthorization(authToken, "operator");
        
        DataObjectMapper<Stock> o = new DataObjectMapper<>(stockLogic.findStockById(id));
        
        return (Stock) o.getEntry();
    
    }
}

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
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

        String a = map.get("name");
        String b = map.get("description");
        String c = map.get("type");
        Double d = new Double(map.get("alcoholcontent"));
        Double e = new Double(map.get("bottlesize"));
        Double f = new Double(map.get("purchaseprice"));
        Double g = new Double(map.get("sellingprice"));
        Integer h = new Integer(map.get("onstockquantity"));
        stockLogic.insertStock(a, b, c, d, e, f, g, h);


    }

    @Path("getallstock")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Stock> getAll(@HeaderParam("authToken") String authToken) throws Exception {

        authorizator.checkAuthorization(authToken, "operator");
        
      
        return stockLogic.findAllStock();

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
        
        
        return stockLogic.findStockById(id);
    }
    
    @Path("editstock/{id}")
    @PUT
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editStock(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id,Map<String, String> map) throws Exception {

        authorizator.checkAuthorization(authToken, "operator");
        
        String a = map.get("name");
        String b = map.get("description");
        String c = map.get("type");
        Double d = new Double(map.get("alcoholcontent"));
        Double e = new Double(map.get("bottlesize"));
        Double f = new Double(map.get("purchaseprice"));
        Double g = new Double(map.get("sellingprice"));
        Integer h = new Integer(map.get("onstockquantity"));
        Stock stock = new Stock(a, b, c, d, e, f, g, h);
        stock.setId(id);
        
        
        stockLogic.editStock(stock);
    }
    @Path("filterstock/{filter}")
    @GET
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Stock> filterStock(@HeaderParam("authToken") String authToken, @PathParam("filter") String filter) throws Exception {

        authorizator.checkAuthorization(authToken, "operator");
        
      
        return stockLogic.filterStockByName(filter);

    }
    
    
    
}

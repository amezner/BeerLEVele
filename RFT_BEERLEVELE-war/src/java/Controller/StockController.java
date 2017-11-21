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

//    faszsetudjahogyezmeeeenemjooooo
//    stockLogic.insertStock(map.get("name"), map.get("description"), map.get("type"), new Double(map.get("alcoholcontent")), new Double(map.get("bottlesize")), new Double(map.get("purcahaseprice")), new Double(map.get("sellingprice")), new Integer(map.get("onstockquantity")));

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
    
    @Path("editstock/{id}")
    @PUT
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editCustomer(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id,Map stockdetail) throws Exception {

        authorizator.checkAuthorization(authToken, "operator");
        Stock stock = new Stock(id);
        stock.setAlcoholcontent(Double.parseDouble((String) stockdetail.get("alcoholcontent")));
        stock.setBottlesize(Double.parseDouble((String) stockdetail.get("bottlesize")));
        stock.setDescription((String) stockdetail.get("description"));
        stock.setName((String) stockdetail.get("name"));
        stock.setOnstockquantity(new Integer((String) stockdetail.get("onstockquantity")));
        stock.setPurchaseprice(Double.parseDouble((String) stockdetail.get("purchaseprice")));
        stock.setSellingprice(Double.parseDouble((String) stockdetail.get("sellingprice")));
        stock.setType((String)stockdetail.get("type"));
        stockLogic.editStock(stock);
    }
}

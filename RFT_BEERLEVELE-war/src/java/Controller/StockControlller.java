/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Stock;
import Helper.Authorizator;
import Logic.StockLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author danida
 */
@Stateless
@LocalBean
public class StockControlller {

    @EJB
    private StockLogic stockLogic;
    @EJB
    private Authorizator authorizator;

    @Path("savestock")
    @POST
    @Produces("text/plain")
    public void saveStock(@HeaderParam("authToken") String authToken, @FormParam("name") String name, @FormParam("description") String description, @FormParam("purchaseprice") int purchaseprice, @FormParam("sellingprice") int sellingprice, @FormParam("onstockquantity") int onstockquantity, @FormParam("type") String type) throws Exception {
        authorizator.checkAuthorization(authToken, "admin");

        stockLogic.insertStock(name, description, purchaseprice, sellingprice, onstockquantity, type);

    }

    @Path("getallstock")
    @GET
    @Produces("application/json")
    public List<Stock> getAll(@HeaderParam("authToken") String authToken) throws Exception {
        authorizator.checkAuthorization(authToken, "customer");

        return stockLogic.findAllStock();

    }

    @Path("deletestock/{id}")
    @DELETE
    public void save(@HeaderParam("authToken") String authToken, @PathParam("id") Integer id) throws Exception {
        authorizator.checkAuthorization(authToken, "admin");

        stockLogic.deleteStockById(id);

    }

    @Path("getstock")
    @GET
    public void getCustomer(@HeaderParam("authToken") String authToken, @QueryParam("id") int id) throws Exception {
        authorizator.checkAuthorization(authToken, "operator");

        stockLogic.findStockById(id);

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Entities.Stock;
import Facades.StockFacade;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danida
 */

@ManagedBean
@Stateless

public class StockLogic {
         
    @Inject
    StockFacade facade;

    public void insertStock(String name, String description, String type, Double alcoholcontent, Double bottlesize, Double purchaseprice, Double sellingprice, Integer onstockquantity) throws Exception {
        Stock stock = new Stock(name, description, type, alcoholcontent, bottlesize, purchaseprice, sellingprice, onstockquantity);
        Logger logger = LoggerFactory.getLogger(StockLogic.class);
        logger.debug("Check, if the stock is persistable");
        if (CheckIfCorrectStock(stock)) {
            facade.create(stock);
        } else {
            throw new Exception("This stock already exists, or the values are not correct");
        }
    }

    public void deleteStockById(Integer id) throws Exception {
        Stock cu = facade.findStockById(id);
        if (cu != null) {
            facade.remove(cu);
        } else {
            throw new Exception("No such a stock");

        }
    }

    public void editStock(Stock cu) {
        facade.edit(cu);
    }

    public List<Stock> findAllStock() {
        return facade.findAll();

    }

    private boolean CheckIfCorrectStock(Stock stock) {
        if (stock.getName()== null || stock.getDescription() == null || stock.getType() == null ||stock.getSellingprice()== null || stock.getPurchaseprice() == null || stock.getOnstockquantity() == null ) {
            return false;
        }
        return true;

    }

    public Stock findStockById(int id) {
        return facade.findStockById(id);

    }

    
}

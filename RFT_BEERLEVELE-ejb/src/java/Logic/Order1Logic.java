/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Entities.Order1;
import Facades.Order1Facade;
import Facades.StockFacade;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author dnovak
 */

@ManagedBean
@Stateless

public class Order1Logic {

    @Inject
    Order1Facade facade;

    @Inject
    StockFacade stockFacade;
    
    public void insertInTheCart(int uid, int stockID, int quantity) throws Exception {

//        String res = "FALSE";
//        if (facade.findStockidQuantityIncart(stockID)+quantity-facade.findInCart(uid, stockID).get(0).getQuantity() < stockFacade.findStockById(stockID).getOnstockquantity())
//            res = "TRUE";
//              
//        throw new Exception(
//                "Result : " + res +
//                "findInCart: " + facade.findInCart(uid, stockID).get(0).getQuantity().toString() 
//                + "| Quantity: "+quantity+
//                "| getOnstockquantity: " + stockFacade.findStockById(stockID).getOnstockquantity().toString() +
//                "| fubdSticjudQuantityIncart: " + facade.findStockidQuantityIncart(stockID).toString() +
//                "| SUM: " + ( facade.findStockidQuantityIncart(stockID)
//                              + quantity 
//                              - facade.findInCart(uid, stockID).get(0).getQuantity())
//        );

        if (stockFacade.findStockById(stockID) == null)
            throw new Exception("StockID does not exist");
        if (quantity <= 0)
            throw new Exception("You can't add ZERO or NEGATIVE items to the cart");  

        Order1 order = new Order1(uid, stockID, quantity);
        if (facade.findInCart(uid, stockID).isEmpty()) {
            if (facade.findStockidQuantityIncart(stockID)+quantity > stockFacade.findStockById(stockID).getOnstockquantity())
                throw new Exception("Not enough stock from this product");
            else
                facade.create(order);
        } else {
            if (facade.findStockidQuantityIncart(stockID)+quantity-facade.findInCart(uid, stockID).get(0).getQuantity() > stockFacade.findStockById(stockID).getOnstockquantity())
                throw new Exception("Not enough stock from this product");
            else {
                order.setId(facade.findInCart(uid, stockID).get(0).getId());
                facade.edit(order);
            }
        }

    }

    public void deleteOrder(int uid, int stockID) throws Exception {
        if (facade.findInCart(uid, stockID).isEmpty())
            throw new Exception("No such order");
        else {
            Order1 order = facade.findInCart(uid, stockID).get(0);
            order.setId(facade.findInCart(uid, stockID).get(0).getId());
            facade.remove(order);
        }
    }

    public void emptyCart(int uid) throws Exception {
        if (facade.findCartByUid(uid).isEmpty())
            throw new Exception("Cart is already empty!");
        else {
            facade.emptyCart(uid);
        }
    }
    
    public List<Order1> findCartByUid (Integer Uid) {
        return facade.findCartByUid(Uid);
    }

    private boolean checkIfOrderValid(String Uid, int stock_id, int quantity) {
        boolean r = true;
        if (Uid.isEmpty() || stock_id == 0 || quantity == 0) {
            r = false;
        }

        return r;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Entities.Order1;
import Facades.Order1Facade;
import Helper.Authenticator;
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

    public void insertInTheCart(int uid, int stockID, int quantity) throws Exception {

        Order1 order = new Order1(uid, stockID, quantity);
        if (facade.findInCart(uid, stockID).isEmpty()) {
            facade.create(order);
        } else {
            order.setId(facade.findInCart(uid, stockID).get(0).getId());
            facade.edit(order);
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

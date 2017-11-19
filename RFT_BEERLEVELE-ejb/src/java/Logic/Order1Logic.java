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

//    public void createNewOrder1(String Uid) throws Exception {
//
//        Order1 order = new Order1(Uid);
//        facade.create(order);
//    }

    public void insertInTheCart(int uid, int stockId, int quantity) throws Exception {

//ez meg kerdojeles resz, tesztelni kell
        if (Authenticator.getAuthorizationTokensStorage().get(uid) == null) {
            throw new Exception("No such user is logged in");
        }

        Order1 order = new Order1(uid, stockId, quantity);
        facade.create(order);
        
    }

    public void deleteOrder1(int id) throws Exception {
        Order1 c = facade.findById(id);
        if (c == null){throw new Exception("No such order");}
        facade.remove(c);
    }

    public List<Order1> findAll(Integer Uid) {
        return facade.findByUid(Uid);

    }

    private boolean checkIfOrderValid(String Uid, int stock_id, int quantity) {
        boolean r = true;
        if (Uid.isEmpty() || stock_id == 0 || quantity == 0) {
            r = false;
        }

        return r;
    }
}

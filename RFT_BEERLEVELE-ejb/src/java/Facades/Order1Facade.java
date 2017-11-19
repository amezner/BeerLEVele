/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Order1;
import Interfaces.FacadeInterface;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dnovak
 */
@LocalBean
@Stateless

public class Order1Facade implements FacadeInterface<Order1> {

    @PersistenceContext(name = "RFT_BEERLEVELE-ejbPU")
    EntityManager em;

    @Override
    public void create(Order1 t) {
        Logger logger = LoggerFactory.getLogger(Order1Facade.class);
        logger.debug("Create cart, ID : ", t.getId());
        em.persist(t);
    }

    @Override
    public void remove(Order1 t) {
        Logger logger = LoggerFactory.getLogger(Order1Facade.class);
        logger.debug("Remove cart, ID : ", t.getId(),", StockID : ",t.getStockId());
        em.remove(t);
    }

    @Override
    public void edit(Order1 t) {
        Logger logger = LoggerFactory.getLogger(Order1Facade.class);
        logger.debug("Editting cart, ID : ", t.getId(),", StockID : ",t.getStockId());
        em.merge(t);
    }

    public List<Order1> findCartByUid (Integer uid){
        Logger logger = LoggerFactory.getLogger(Order1Facade.class);
        logger.debug("Find a cart by UID");
        return em.createNamedQuery("Order1.findCartByUid").setParameter("uid", uid).getResultList();
    }

    public List<Order1> findInCart (Integer uid, Integer stock_id){
        Logger logger = LoggerFactory.getLogger(Order1Facade.class);
        logger.debug("Find a stock item in UID's cart");
        return em.createNamedQuery("Order1.findInCart").setParameter("uid", uid).setParameter("stock_id", stock_id).getResultList();
    }
    
}

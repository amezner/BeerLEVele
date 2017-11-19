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
        logger.debug("Create cart");
        em.persist(t);
    }

    @Override
    public void remove(Order1 t) {
        Logger logger = LoggerFactory.getLogger(Order1Facade.class);
        logger.debug("Remove cart");
        em.remove(t);
    }

    @Override
    public void edit(Order1 t) {
        Logger logger = LoggerFactory.getLogger(Order1Facade.class);
        logger.debug("Editting cart");
        em.merge(t);
    }

    public List<Order1> findAll() {
        Logger logger = LoggerFactory.getLogger(Order1Facade.class);
        logger.debug("Find all carts");
        return em.createNamedQuery("Order1.findAll").getResultList();
    }

    public Order1 findById(int Id) {
        Logger logger = LoggerFactory.getLogger(Order1Facade.class);
        logger.debug("Find a cart");
        return (Order1) em.createNamedQuery("Order1.findById").setParameter("id", Id).getResultList().get(0);
    }

    public List<Order1> findByUid (Integer uid){
        Logger logger = LoggerFactory.getLogger(Order1Facade.class);
        logger.debug("Find a cart by UID");
        return em.createNamedQuery("Order1.findByUid").setParameter("uid", uid).getResultList();
    }
    

}

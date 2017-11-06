/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Stock;
import Interfaces.FacadeInterface;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danida
 */
public class StockFacade implements FacadeInterface<Stock> {

    @PersistenceContext(name = "RFT_BEERLEVELE-ejbPU")
    EntityManager em;

    @Override
    public void create(Stock cu) {
        Logger logger = LoggerFactory.getLogger(StockFacade.class);
        logger.debug("Persist stock");
        em.persist(cu);
    }

    @Override
    public void remove(Stock t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Stock t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Stock> findAll() {
        return em.createNamedQuery("Stock.findAll").getResultList();
    }

    public List<Stock> findStockByName(String name) {
        Logger logger = LoggerFactory.getLogger(StockFacade.class);
        logger.debug("findStockbyname");
        return em.createNamedQuery("Stock.findByName").setParameter("name", name).getResultList();
    }

    public Stock findStockById(Integer id) {
        Logger logger = LoggerFactory.getLogger(StockFacade.class);
        logger.debug("findStockbyId");
        return (Stock) em.createNamedQuery("Stock.findById").setParameter("id", id).getResultList().get(0);
    }

    public List<Stock> findStockByPurchaseprice(Integer purchaseprice) {
        Logger logger = LoggerFactory.getLogger(StockFacade.class);
        logger.debug("findStockbyId");
        return em.createNamedQuery("Stock.findByPurchaseprice").setParameter("purchaseprice", purchaseprice).getResultList();
    }

    public List<Stock> findStockBySellingprice(Integer sellingprice) {
        Logger logger = LoggerFactory.getLogger(StockFacade.class);
        logger.debug("findStockbyId");
        return em.createNamedQuery("Stock.findBySellingprice").setParameter("sellingprice", sellingprice).getResultList();
    }

    public List<Stock> findStockByOnStockQuantity(Integer quantity) {
        Logger logger = LoggerFactory.getLogger(StockFacade.class);
        logger.debug("findStockbyQuantity");
        return em.createNamedQuery("Stock.findByOnstockquantity").setParameter("onstockquantity", quantity).getResultList();

    }

}

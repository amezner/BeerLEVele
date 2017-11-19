/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Stock;
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
 * @author danida
 */

@LocalBean
@Stateless
public class StockFacade implements FacadeInterface<Stock> {

    @PersistenceContext(name = "RFT_BEERLEVELE-ejbPU")
    EntityManager em;

    @Override
    public void create(Stock stock) {
        Logger logger = LoggerFactory.getLogger(StockFacade.class);
        logger.debug("Create stock, ID : ", stock.getId());
        em.persist(stock);
    }

    @Override
    public void remove(Stock stock) {
        Logger logger = LoggerFactory.getLogger(StockFacade.class);
        logger.debug("Remove stock, ID : ", stock.getId());
        em.remove(stock);    
    }

    @Override
    public void edit(Stock stock) {
        Logger logger = LoggerFactory.getLogger(StockFacade.class);
        logger.debug("Edit stock, ID : ", stock.getId());
        em.merge(stock);
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

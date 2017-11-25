/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Invoicedproducts;
import Interfaces.FacadeInterface;
import static java.lang.Math.log;
import static java.rmi.server.LogStream.log;
import java.util.logging.Level;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danida
 */
@LocalBean
@Stateless
public class InvoicedproductsFacade implements FacadeInterface<Invoicedproducts> {

    @PersistenceContext(name = "RFT_BEERLEVELE-ejbPU")
    EntityManager em;

    @Override
    public void create(Invoicedproducts ip) {
        Logger logger = LoggerFactory.getLogger(InvoicedproductsFacade.class);
        logger.debug("Create invoiced item, ID : ", ip.getId());
        try {
           em.persist(ip);
        } catch (ConstraintViolationException e) {
          throw new UnsupportedOperationException(e.getConstraintViolations().toString());
       }
    }

    @Override
    public void remove(Invoicedproducts ip) {
        throw new UnsupportedOperationException("Not needed, deleting an item from invoice is not required.");
    }

    @Override
    public void edit(Invoicedproducts ip) {
        throw new UnsupportedOperationException("Not needed, editing an item from invoice is not required.");
    }

}

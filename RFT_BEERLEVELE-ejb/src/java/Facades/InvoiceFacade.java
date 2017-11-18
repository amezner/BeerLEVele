/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Invoice;
import Interfaces.FacadeInterface;
import java.util.Date;
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
public class InvoiceFacade implements FacadeInterface<Invoice>{

    @PersistenceContext(name = "RFT_BEERLEVELE-ejbPU")
    EntityManager em;

    
    
    @Override
    public void create(Invoice t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Invoice t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Invoice t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Invoice> findAll() {
        Logger logger = LoggerFactory.getLogger(InvoiceFacade.class);
        logger.debug("findAllInvoices");
        return em.createNamedQuery("Invoice.findAll").getResultList();
    }

    public Invoice findByInvoicenumber(int invoicenumber) {
        Logger logger = LoggerFactory.getLogger(InvoiceFacade.class);
        logger.debug("findInvoicebyInvoicenumber");
        return (Invoice) em.createNamedQuery("Invoice.findByInvoicenumber").setParameter("invoicenumber", invoicenumber).getResultList().get(0);
    }

    public List<Invoice> findInvoiceByDate(Date date) {
        Logger logger = LoggerFactory.getLogger(InvoiceFacade.class);
        logger.debug("findInvoiceByDate");
        return em.createNamedQuery("Invoice.findByDate").setParameter("date", date).getResultList();

    }
    public List<Invoice> findInvoiceByDiscount(Integer discount){
        Logger logger = LoggerFactory.getLogger(InvoiceFacade.class);
        logger.debug("findInvoiceByDiscount");
        return em.createNamedQuery("Invoice.findByDiscount").setParameter("discount", discount).getResultList();
    }

   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Invoice;
import Interfaces.FacadeInterface;
import java.util.List;
import java.util.Map;
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
        Logger logger = LoggerFactory.getLogger(Order1Facade.class);
        logger.info("Create invoice, InvoiceNumber: ", t.getInvoicenumber());
        em.persist(t);
                
    }

    @Override
    public void remove(Invoice t) {
        throw new UnsupportedOperationException("Not needed, deleting an invoice is not required.");
    }

    @Override
    public void edit(Invoice t) {
        throw new UnsupportedOperationException("Not needed, invoices are not editable.");
    }
    
    public List<Invoice> findAll() {
        Logger logger = LoggerFactory.getLogger(InvoiceFacade.class);
        logger.debug("findAllInvoices");
        return em.createNamedQuery("Invoice.findAll").getResultList();
    }

    public Invoice findByInvoicenumber(int invoicenumber) throws Exception {
        Logger logger = LoggerFactory.getLogger(InvoiceFacade.class);
        logger.debug("findInvoicebyInvoicenumber");
        if (em.createNamedQuery("Invoice.findByInvoicenumber").setParameter("invoicenumber", invoicenumber).getResultList().isEmpty())
            throw new Exception ("Can not find invoice: " + invoicenumber);
        else
            return (Invoice) em.createNamedQuery("Invoice.findByInvoicenumber").setParameter("invoicenumber", invoicenumber).getResultList().get(0);
    }

    public List profitPerInvoice() {
        Logger logger = LoggerFactory.getLogger(InvoiceFacade.class);
        logger.debug("profitPerInvoice");
        return em.createNativeQuery("SELECT i.invoicenumber, i.name, (SELECT sum(ip.soldprice-ip.purchaseprice) * ip.soldquantity FROM invoicedproducts ip WHERE ip.invoicenumber = i.invoicenumber) AS profit FROM invoice i").getResultList();
    }

    public List stockConsumption() {
        Logger logger = LoggerFactory.getLogger(InvoiceFacade.class);
        logger.debug("stockConsumption");
        return em.createNativeQuery("select ip.stockid, ip.name, sum(ip.soldquantity) as quantity, month(i.date) as month, year(i.date) as year, sum(ip.soldquantity * ip.soldprice) as income, sum(ip.soldquantity * ip.purchaseprice) as purchase from invoicedproducts as ip join invoice i on i.invoicenumber = ip.invoicenumber group by ip.stockid, month(i.date), year(i.date)").getResultList();
    }
}
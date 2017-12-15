/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Invoice;
import Helper.StockConsumption;
import Interfaces.FacadeInterface;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EntityManager;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danida
 */

@LocalBean
@Stateless
public class InvoiceFacade implements FacadeInterface<Invoice> {

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
        if (em.createNamedQuery("Invoice.findByInvoicenumber").setParameter("invoicenumber", invoicenumber).getResultList().isEmpty()) {
            throw new Exception("Can not find invoice: " + invoicenumber);
        } else {
            return (Invoice) em.createNamedQuery("Invoice.findByInvoicenumber").setParameter("invoicenumber", invoicenumber).getResultList().get(0);
        }
    }

    public List<StockConsumption> stockConsumptionPerMonth() {
        Logger logger = LoggerFactory.getLogger(InvoiceFacade.class);
        logger.debug("stockConsumption");
        return em.createNamedQuery("Invoice.stockConsumptionPerMonth").getResultList();
 
    }

    public List<StockConsumption> stockConsumptionPerStock(Integer id) {
        Logger logger = LoggerFactory.getLogger(InvoiceFacade.class);
        logger.debug("stockConsumption");
        return em.createNamedQuery("Invoice.stockConsumptionPerStock").setParameter(1, id).getResultList();
    }

}

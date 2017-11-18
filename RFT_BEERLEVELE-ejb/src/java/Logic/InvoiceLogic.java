/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Entities.Invoice;
import Facades.InvoiceFacade;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author danida
 */

@ManagedBean
@Stateless

public class InvoiceLogic {
    
    @Inject
    InvoiceFacade facade;
    
    public List<Invoice> findAllInvoices() {
        return facade.findAll();

    }
    
    public Invoice findInvoiceByInvoicenumber(int invoicenumber) {
        return facade.findByInvoicenumber(invoicenumber);

    }

    public void closeInvoice() {
        //TODO

    }
}

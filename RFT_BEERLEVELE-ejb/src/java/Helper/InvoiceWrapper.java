/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Entities.Invoice;
import Entities.Invoicedproducts;
import java.util.Collection;

/**
 *
 * @author dnovak
 */
public class InvoiceWrapper extends Invoice{
    private Collection<Invoicedproducts> invoicedproducts;

    public InvoiceWrapper(Invoice i) {
        this.setAddress(i.getAddress());
        this.setCity(i.getCity());
        this.setCountry(i.getCountry());
        this.setInvoicedproducts(i.getInvoicedproductsCollection());
        this.setCustomerId(i.getCustomerId());
        this.setDate(i.getDate());
        this.setDiscount(i.getDiscount());
        this.setEmail(i.getEmail());
        this.setInvoicenumber(i.getInvoicenumber());
        this.setLoyaltycard(i.getLoyaltycard());
        this.setName(i.getName());
        this.setPhone(i.getPhone());
        this.setPostalcode(i.getPostalcode());
        
    }
    public Collection<Invoicedproducts> getInvoicedproducts() {
        return invoicedproducts;
    }

    public void setInvoicedproducts(Collection<Invoicedproducts> invoicedproducts) {
        this.invoicedproducts = invoicedproducts;
    }
    
}

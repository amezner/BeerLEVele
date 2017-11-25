/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Entities.Invoice;
import Entities.Invoicedproducts;
import Entities.Order1;
import Facades.CustomerFacade;
import Facades.InvoiceFacade;
import Facades.InvoicedproductsFacade;
import Facades.Order1Facade;
import Facades.StockFacade;
import Helper.InvoiceWrapper;
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
    InvoiceFacade invoiceFacade;
    
    @Inject
    Order1Facade orderFacade;

    @Inject
    StockFacade stockFacade;
    
    @Inject
    CustomerFacade customerFacade;
    
    @Inject
    InvoicedproductsFacade ipFacade;
    
    public List<Invoice> findAllInvoices() {
        return invoiceFacade.findAll();

    }
    
    public InvoiceWrapper findInvoiceByInvoicenumber(int invoicenumber) throws Exception {
         Invoice i = invoiceFacade.findByInvoicenumber(invoicenumber);
         InvoiceWrapper iw = new InvoiceWrapper(i);
         return iw;

    }

    public void closeInvoice(int uid, int customer_id) throws Exception {
        
        if (orderFacade.findCartByUid(uid).isEmpty()) 
            throw new Exception("Cart is empty, please add items to cart before closing invoice");
        if (customerFacade.findById(customer_id) == null)
            throw new Exception("Invalid customer ID");
        Invoice invoice = new Invoice(
                customerFacade.findById(customer_id).getId(),
                customerFacade.findById(customer_id).getName(),
                customerFacade.findById(customer_id).getCountry(),
                customerFacade.findById(customer_id).getCity(),
                customerFacade.findById(customer_id).getAddress(),
                customerFacade.findById(customer_id).getPostalcode(),
                customerFacade.findById(customer_id).getEmail(),
                customerFacade.findById(customer_id).getPhone(),
                customerFacade.findById(customer_id).getLoyaltycard(),
                customerFacade.findById(customer_id).getDiscount()
        );
        
        invoiceFacade.create(invoice);
               
        for (Order1 o : orderFacade.findCartByUid(uid)) {
            Invoicedproducts ip = new Invoicedproducts(
                o.getStockId(),
                stockFacade.findStockById(o.getStockId()).getName(),
                stockFacade.findStockById(o.getStockId()).getType(),
                stockFacade.findStockById(o.getStockId()).getAlcoholcontent(),
                stockFacade.findStockById(o.getStockId()).getBottlesize(),
                stockFacade.findStockById(o.getStockId()).getPurchaseprice(),
                stockFacade.findStockById(o.getStockId()).getSellingprice() * (100 - customerFacade.findById(uid).getDiscount())/100,
                o.getQuantity()
            );
            ip.setInvoice(invoice);
            ipFacade.create(ip);
        }
        
        orderFacade.emptyCart(uid);
        
    }
}

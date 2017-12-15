/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Entities.Invoice;
import Entities.Invoicedproducts;
import Entities.Order1;
import Entities.Stock;
import Facades.CustomerFacade;
import Facades.InvoiceFacade;
import Facades.InvoicedproductsFacade;
import Facades.Order1Facade;
import Facades.StockFacade;
import Helper.InvoiceWrapper;
import Helper.ProfitPerInvoice;
import Helper.StockConsumption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
                stockFacade.findStockById(o.getStockId()).getSellingprice() * (100 - customerFacade.findById(customer_id).getDiscount())/100,
                o.getQuantity()
            );
            ip.setInvoice(invoice);
            ipFacade.create(ip);

            invoice.getInvoicedproductsCollection().add(ip);

            Stock updatestock = stockFacade.findStockById(o.getStockId());
            updatestock.setOnstockquantity(updatestock.getOnstockquantity() - o.getQuantity());
            stockFacade.edit(updatestock);
            
        }

        orderFacade.emptyCart(uid);
        
    }
    
    public List<ProfitPerInvoice> profitPerInvoice() {
        List<Invoice> invoices = invoiceFacade.findAll();
        List<ProfitPerInvoice> profitPerInvoiceList  = new ArrayList<>();
        
        
        
        for (Invoice i : invoices){
            
            ProfitPerInvoice pi = new ProfitPerInvoice(i.getInvoicenumber(), i.getName(),calculateProfit(i) ); 
            profitPerInvoiceList.add(pi);
        }
        return profitPerInvoiceList;

    }
    
    public List<StockConsumption> stockConsumptionPerMonth() {
        return invoiceFacade.stockConsumptionPerMonth();

    }
    public List<StockConsumption> stockConsumptionPerStock(Integer id) {
        return invoiceFacade.stockConsumptionPerStock(id);

    }
    
    
    public Double calculateProfit(Invoice i){
       Collection<Invoicedproducts> lista =  i.getInvoicedproductsCollection();
       Double profit = 0.0;
       profit = lista.stream().map((ip) -> (ip.getSoldprice()-ip.getPurchaseprice())*ip.getSoldquantity()).reduce(profit, (accumulator, _item) -> accumulator + _item);
       return profit;
    }
    
    
}

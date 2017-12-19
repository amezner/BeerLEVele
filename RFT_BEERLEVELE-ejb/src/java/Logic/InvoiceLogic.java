/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Entities.Customer;
import Entities.Invoice;
import Entities.Invoicedproducts;
import Entities.Order1;
import Entities.Stock;
import Facades.CustomerFacade;
import Facades.InvoiceFacade;
import Facades.InvoicedproductsFacade;
import Facades.Order1Facade;
import Facades.StockFacade;
import Helper.Email;
import Helper.InvoiceWrapper;
import Helper.PDFGeneration;
import Helper.ProfitPerInvoice;
import Helper.StockConsumption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author danida
 */

@ManagedBean
@Stateless

public class InvoiceLogic {

    @EJB
    private Email email;
    
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
        
        Customer customer = customerFacade.findById(customer_id);
        Invoice invoice = new Invoice(
                customer.getId(),
                customer.getName(),
                customer.getCountry(),
                customer.getCity(),
                customer.getAddress(),
                customer.getPostalcode(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getLoyaltycard(),
                customer.getDiscount()
        );

        invoiceFacade.create(invoice);
             
        for (Order1 o : orderFacade.findCartByUid(uid)) {
            Stock stock = stockFacade.findStockById(o.getStockId());
            Invoicedproducts ip = new Invoicedproducts(
                o.getStockId(),
                stock.getName(),
                stock.getType(),
                stock.getAlcoholcontent(),
                stock.getBottlesize(),
                stock.getPurchaseprice(),
                stock.getSellingprice() * (100 - customer.getDiscount())/100,
                o.getQuantity()
            );
            ip.setInvoice(invoice);
            ipFacade.create(ip);

            invoice.getInvoicedproductsCollection().add(ip);

            Stock updatestock = stockFacade.findStockById(o.getStockId());
            updatestock.setOnstockquantity(updatestock.getOnstockquantity() - o.getQuantity());
            stockFacade.edit(updatestock);
            
        }
        PDFGeneration pdfgenerator = new PDFGeneration(invoice, customer);
        email.SendMaiWithAttachment(customer.getEmail(), "Tisztelt " + customer.getName() + ",\n\n\n Számlája érkezett.\n\n Üdvözlettel,\nBeerLevele Zrt.\n");
        
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
    
    public static String generateInvoiceNumber(Invoice i){
        String r = i.getDate().getYear()+1900 + "/" + String.format("%06d", i.getInvoicenumber());
        return r;
    }
    
    
}

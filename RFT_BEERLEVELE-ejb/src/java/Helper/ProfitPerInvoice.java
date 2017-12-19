/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author dnovak
 */
public class ProfitPerInvoice {

    private Integer invoicenumber;
    private String name;
    private Double profit;

    public ProfitPerInvoice() {
    }

     
    public ProfitPerInvoice(Integer invoicenumber, String name, Double profit) {
        this.invoicenumber = invoicenumber;
        this.name = name;
        this.profit = profit;
    }

    public Integer getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(Integer invoicenumber) {
        this.invoicenumber = invoicenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }
    
    
    
}

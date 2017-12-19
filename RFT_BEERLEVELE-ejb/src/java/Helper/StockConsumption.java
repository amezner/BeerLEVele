/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.math.BigDecimal;


/**
 *
 * @author dnovak
 */
public class StockConsumption {

    private Integer stockid;
    private BigDecimal quantity;
    private Integer month;
    private Integer year;
    private Double avg_purchase;
    private Double avg_sold;
    private Double avg_profit;
    private Double income;
    private Double purchase;
    private Double profit;

    public StockConsumption() {
       
    }


    public StockConsumption(Integer stockid, BigDecimal quantity, Integer month, Integer year, Double avg_purchase, Double avg_sold, Double avg_profit, Double income, Double purchase, Double profit) {
        this.stockid = stockid;
        this.quantity = quantity;
        this.month = month;
        this.year = year;
        this.avg_purchase = avg_purchase;
        this.avg_sold = avg_sold;
        this.avg_profit = avg_profit;
        this.income = income;
        this.purchase = purchase;
        this.profit = profit;
    }

    public Integer getStockid() {
        return stockid;
    }

    public void setStockid(Integer stockid) {
        this.stockid = stockid;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getAvg_purchase() {
        return avg_purchase;
    }

    public void setAvg_purchase(Double avg_purchase) {
        this.avg_purchase = avg_purchase;
    }

    public Double getAvg_sold() {
        return avg_sold;
    }

    public void setAvg_sold(Double avg_sold) {
        this.avg_sold = avg_sold;
    }

    public Double getAvg_profit() {
        return avg_profit;
    }

    public void setAvg_profit(Double avg_profit) {
        this.avg_profit = avg_profit;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getPurchase() {
        return purchase;
    }

    public void setPurchase(Double purchase) {
        this.purchase = purchase;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "StockConsumption{" + "stockid=" + stockid + ", quantity=" + quantity + ", month=" + month + ", year=" + year + ", avg_purchase=" + avg_purchase + ", avg_sold=" + avg_sold + ", avg_profit=" + avg_profit + ", income=" + income + ", purchase=" + purchase + ", profit=" + profit + '}';
    }
    

    
    
    
    
}

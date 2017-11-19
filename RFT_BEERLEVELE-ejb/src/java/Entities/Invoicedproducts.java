/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mezner
 */
@Entity
@Table(name = "invoicedproducts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoicedproducts.findAll", query = "SELECT i FROM Invoicedproducts i")
    , @NamedQuery(name = "Invoicedproducts.findById", query = "SELECT i FROM Invoicedproducts i WHERE i.id = :id")
    , @NamedQuery(name = "Invoicedproducts.findByName", query = "SELECT i FROM Invoicedproducts i WHERE i.name = :name")
    , @NamedQuery(name = "Invoicedproducts.findByType", query = "SELECT i FROM Invoicedproducts i WHERE i.type = :type")
    , @NamedQuery(name = "Invoicedproducts.findByAlcoholcontent", query = "SELECT i FROM Invoicedproducts i WHERE i.alcoholcontent = :alcoholcontent")
    , @NamedQuery(name = "Invoicedproducts.findByBottlesize", query = "SELECT i FROM Invoicedproducts i WHERE i.bottlesize = :bottlesize")
    , @NamedQuery(name = "Invoicedproducts.findByPurchaseprice", query = "SELECT i FROM Invoicedproducts i WHERE i.purchaseprice = :purchaseprice")
    , @NamedQuery(name = "Invoicedproducts.findBySoldprice", query = "SELECT i FROM Invoicedproducts i WHERE i.soldprice = :soldprice")
    , @NamedQuery(name = "Invoicedproducts.findBySoldquantity", query = "SELECT i FROM Invoicedproducts i WHERE i.soldquantity = :soldquantity")
    , @NamedQuery(name = "Invoicedproducts.findBySoldsubtotal", query = "SELECT i FROM Invoicedproducts i WHERE i.soldsubtotal = :soldsubtotal")})
public class Invoicedproducts implements Serializable {

    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @Size(max = 20)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alcoholcontent")
    private double alcoholcontent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bottlesize")
    private double bottlesize;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "purchaseprice")
    private Double purchaseprice;
    @Column(name = "soldprice")
    private Double soldprice;
    @Column(name = "soldquantity")
    private Integer soldquantity;
    @Column(name = "soldsubtotal")
    private Double soldsubtotal;
    @JoinColumn(name = "stockid", referencedColumnName = "ID")
    @ManyToOne
    private Stock stockid;
    @JoinColumn(name = "invoicenumber", referencedColumnName = "invoicenumber")
    @ManyToOne
    private Invoice invoicenumber;

    public Invoicedproducts() {
    }

    public Invoicedproducts(Integer id) {
        this.id = id;
    }

    public Invoicedproducts(Integer id, double alcoholcontent, double bottlesize) {
        this.id = id;
        this.alcoholcontent = alcoholcontent;
        this.bottlesize = bottlesize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(Double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public Double getSoldprice() {
        return soldprice;
    }

    public void setSoldprice(Double soldprice) {
        this.soldprice = soldprice;
    }

    public Integer getSoldquantity() {
        return soldquantity;
    }

    public void setSoldquantity(Integer soldquantity) {
        this.soldquantity = soldquantity;
    }

    public Double getSoldsubtotal() {
        return soldsubtotal;
    }

    public void setSoldsubtotal(Double soldsubtotal) {
        this.soldsubtotal = soldsubtotal;
    }

    public Stock getStockid() {
        return stockid;
    }

    public void setStockid(Stock stockid) {
        this.stockid = stockid;
    }

    public Invoice getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(Invoice invoicenumber) {
        this.invoicenumber = invoicenumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoicedproducts)) {
            return false;
        }
        Invoicedproducts other = (Invoicedproducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Invoicedproducts[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAlcoholcontent() {
        return alcoholcontent;
    }

    public void setAlcoholcontent(double alcoholcontent) {
        this.alcoholcontent = alcoholcontent;
    }

    public double getBottlesize() {
        return bottlesize;
    }

    public void setBottlesize(double bottlesize) {
        this.bottlesize = bottlesize;
    }
    
}

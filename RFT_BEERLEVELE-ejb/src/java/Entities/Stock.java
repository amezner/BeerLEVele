/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danida
 */
@Entity
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findById", query = "SELECT s FROM Stock s WHERE s.id = :id")
    , @NamedQuery(name = "Stock.findByName", query = "SELECT s FROM Stock s WHERE s.name = :name")
    , @NamedQuery(name = "Stock.findByDescription", query = "SELECT s FROM Stock s WHERE s.description = :description")
    , @NamedQuery(name = "Stock.findByPurchaseprice", query = "SELECT s FROM Stock s WHERE s.purchaseprice = :purchaseprice")
    , @NamedQuery(name = "Stock.findBySellingprice", query = "SELECT s FROM Stock s WHERE s.sellingprice = :sellingprice")
    , @NamedQuery(name = "Stock.findByOnstockquantity", query = "SELECT s FROM Stock s WHERE s.onstockquantity = :onstockquantity")
    , @NamedQuery(name = "Stock.findByType", query = "SELECT s FROM Stock s WHERE s.type = :type")})
public class Stock implements Serializable {

    @OneToMany(mappedBy = "stockId")
    private Collection<Order1> order1Collection;

    

    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "purchaseprice")
    private Double purchaseprice;
    @Column(name = "sellingprice")
    private Double sellingprice;
    @Size(max = 20)
    @Column(name = "type")
    private String type;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "onstockquantity")
    private Integer onstockquantity;

    public Stock() {
    }

    public Stock(String name, String description, Double purchaseprice, Double sellingprice, Integer onstockquantity, String type) {
        this.name = name;
        this.description = description;
        this.purchaseprice = purchaseprice;
        this.sellingprice = sellingprice;
        this.onstockquantity = onstockquantity;
        this.type = type;
    }

    public Stock(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getOnstockquantity() {
        return onstockquantity;
    }

    public void setOnstockquantity(Integer onstockquantity) {
        this.onstockquantity = onstockquantity;
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
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Stock[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(Double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public Double getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(Double sellingprice) {
        this.sellingprice = sellingprice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

 

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }
    
}

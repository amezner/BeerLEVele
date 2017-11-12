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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "purchaseprice")
    private Integer purchaseprice;
    @Column(name = "sellingprice")
    private Integer sellingprice;
    @Column(name = "onstockquantity")
    private Integer onstockquantity;
    @Size(max = 20)
    @Column(name = "type")
    private String type;

    public Stock() {
    }

    public Stock(String name, String description, Integer purchaseprice, Integer sellingprice, Integer onstockquantity, String type) {
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

    public Integer getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(Integer purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public Integer getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(Integer sellingprice) {
        this.sellingprice = sellingprice;
    }

    public Integer getOnstockquantity() {
        return onstockquantity;
    }

    public void setOnstockquantity(Integer onstockquantity) {
        this.onstockquantity = onstockquantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    
}

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dnovak
 */
@Entity
@Table(name = "order1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findStockidQuantityIncart", query = "SELECT COALESCE(SUM(o.quantity),0) FROM Order1 o WHERE o.stockId = :stock_id"),
    @NamedQuery(name = "Order1.findByStockid", query = "SELECT o FROM Order1 o WHERE o.stockId = :stock_id"),
    @NamedQuery(name = "Order1.findInCart", query = "SELECT o FROM Order1 o WHERE o.uid = :uid AND o.stockId = :stock_id"),
    @NamedQuery(name = "Order1.findCartByUid", query = "SELECT o FROM Order1 o WHERE o.uid = :uid"),
    @NamedQuery(name = "Order1.emptyCart", query = "DELETE FROM Order1 o WHERE o.uid = :uid")
})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "quantity")
    private Integer quantity;

//    @JoinColumn(name = "stock_id", referencedColumnName = "ID")
//    @ManyToOne
    @Column(name = "stock_id")
    private Integer stockId;

    public Order1() {
    }

    public Order1(Integer id) {
        this.id = id;
    }
    
    public Order1(int uid, int stockId, int quantity) {
        this.uid = uid;
        this.stockId = stockId;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Order1[ id=" + id + " ]";
    }

}

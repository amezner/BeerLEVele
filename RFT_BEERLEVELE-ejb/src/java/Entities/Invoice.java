/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danida
 */
@Entity
@Table(name = "invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i")
    , @NamedQuery(name = "Invoice.findByInvoicenumber", query = "SELECT i FROM Invoice i WHERE i.invoicenumber = :invoicenumber")
    , @NamedQuery(name = "Invoice.findByDate", query = "SELECT i FROM Invoice i WHERE i.date = :date")
    , @NamedQuery(name = "Invoice.findByDiscount", query = "SELECT i FROM Invoice i WHERE i.discount = :discount")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoicenumber")
    private Integer invoicenumber;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "discount")
    private Integer discount;
    @JoinColumn(name = "customer_id", referencedColumnName = "ID")
    @ManyToOne
    private Customer customerId;

    public Invoice() {
    }

    public Invoice(Integer invoicenumber) {
        this.invoicenumber = invoicenumber;
    }

    public Integer getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(Integer invoicenumber) {
        this.invoicenumber = invoicenumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoicenumber != null ? invoicenumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoicenumber == null && other.invoicenumber != null) || (this.invoicenumber != null && !this.invoicenumber.equals(other.invoicenumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Invoice[ invoicenumber=" + invoicenumber + " ]";
    }
    
}

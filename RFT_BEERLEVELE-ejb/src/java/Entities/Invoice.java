/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danida
 */
@Entity
@Table(name = "invoice")
@SecondaryTable (name = "invoicedproducts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i ORDER BY i.date DESC"),
    @NamedQuery(name = "Invoice.findByInvoicenumber", query = "SELECT i FROM Invoice i WHERE i.invoicenumber = :invoicenumber"),
})

public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoicenumber")
    private Integer invoicenumber;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Invoicedproducts> invoicedproductsCollection;

    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @Size(max = 50)
    @Column(name = "country")
    private String country;

    @Size(max = 50)
    @Column(name = "city")
    private String city;

    @Size(max = 200)
    @Column(name = "address")
    private String address;

    @Size(max = 15)
    @Column(name = "postalcode")
    private String postalcode;

    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @Size(max = 20)
    @Column(name = "phone")
    private String phone;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "loyaltycard")
    private Boolean loyaltycard;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "customer_id")
    private int customerId;

    public Invoice() {
    }

    public Invoice(Integer customer_id, String name, String country, String city, String address, String postalcode, String email, String phone, Boolean loyaltycard, Integer discount) {
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        this.date = new Date(stamp.getTime());
        this.customerId = customer_id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.postalcode = postalcode;
        this.email = email;
        this.phone = phone;
        this.loyaltycard = loyaltycard;
        this.discount = discount;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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

    public Boolean getLoyaltycard() {
        return loyaltycard;
    }

    public void setLoyaltycard(Boolean loyaltycard) {
        this.loyaltycard = loyaltycard;
    }

    @XmlTransient
    public Collection<Invoicedproducts> getInvoicedproductsCollection() {
        if (invoicedproductsCollection == null) 
            invoicedproductsCollection = new ArrayList<>();
        return invoicedproductsCollection;
    }

    public void setInvoicedproductsCollection(Collection<Invoicedproducts> invoicedproductsCollection) {
        this.invoicedproductsCollection = invoicedproductsCollection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

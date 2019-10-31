/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.dukesbookstore.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s"),
    @NamedQuery(name = "Sales.findBySaleItemId", query = "SELECT s FROM Sales s WHERE s.saleItemId = :saleItemId"),
    @NamedQuery(name = "Sales.findBySaleDate", query = "SELECT s FROM Sales s WHERE s.saleDate = :saleDate"),
    @NamedQuery(name = "Sales.findBySalePrice", query = "SELECT s FROM Sales s WHERE s.salePrice = :salePrice")})
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SaleItemId")
    private Integer saleItemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SaleDate")
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SalePrice")
    private Double salePrice;
    @JoinColumn(name = "SaleItemId", referencedColumnName = "SaleItemId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Saleitem saleitem;
    @JoinColumn(name = "TradedSaleItemId", referencedColumnName = "SaleItemId")
    @OneToOne
    private Saleitem tradedSaleItemId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sales")
    private Collection<Invoiceditems> invoiceditemsCollection;

    public Sales() {
    }

    public Sales(Integer saleItemId) {
        this.saleItemId = saleItemId;
    }

    public Sales(Integer saleItemId, Date saleDate) {
        this.saleItemId = saleItemId;
        this.saleDate = saleDate;
    }

    public Integer getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(Integer saleItemId) {
        this.saleItemId = saleItemId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Saleitem getSaleitem() {
        return saleitem;
    }

    public void setSaleitem(Saleitem saleitem) {
        this.saleitem = saleitem;
    }

    public Saleitem getTradedSaleItemId() {
        return tradedSaleItemId;
    }

    public void setTradedSaleItemId(Saleitem tradedSaleItemId) {
        this.tradedSaleItemId = tradedSaleItemId;
    }

    @XmlTransient
    public Collection<Invoiceditems> getInvoiceditemsCollection() {
        return invoiceditemsCollection;
    }

    public void setInvoiceditemsCollection(Collection<Invoiceditems> invoiceditemsCollection) {
        this.invoiceditemsCollection = invoiceditemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleItemId != null ? saleItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.saleItemId == null && other.saleItemId != null) || (this.saleItemId != null && !this.saleItemId.equals(other.saleItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaeetutorial.dukesbookstore.entity.Sales[ saleItemId=" + saleItemId + " ]";
    }
    
}

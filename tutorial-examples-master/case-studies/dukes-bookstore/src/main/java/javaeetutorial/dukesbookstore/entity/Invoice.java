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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findByInvoiceId", query = "SELECT i FROM Invoice i WHERE i.invoiceId = :invoiceId"),
    @NamedQuery(name = "Invoice.findByInvAmount", query = "SELECT i FROM Invoice i WHERE i.invAmount = :invAmount"),
    @NamedQuery(name = "Invoice.findByGst", query = "SELECT i FROM Invoice i WHERE i.gst = :gst"),
    @NamedQuery(name = "Invoice.findByInvTotal", query = "SELECT i FROM Invoice i WHERE i.invTotal = :invTotal"),
    @NamedQuery(name = "Invoice.findByCreatedDtm", query = "SELECT i FROM Invoice i WHERE i.createdDtm = :createdDtm"),
    @NamedQuery(name = "Invoice.findByOutstandingAmount", query = "SELECT i FROM Invoice i WHERE i.outstandingAmount = :outstandingAmount"),
    @NamedQuery(name = "Invoice.findByInvoiceSent", query = "SELECT i FROM Invoice i WHERE i.invoiceSent = :invoiceSent")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "InvoiceId")
    private Integer invoiceId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "InvAmount")
    private Double invAmount;
    @Column(name = "Gst")
    private Double gst;
    @Column(name = "InvTotal")
    private Double invTotal;
    @Column(name = "CreatedDtm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDtm;
    @Column(name = "OutstandingAmount")
    private Double outstandingAmount;
    @Column(name = "InvoiceSent")
    private Boolean invoiceSent;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @OneToOne
    private Users userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    private Collection<Invoiceditems> invoiceditemsCollection;

    public Invoice() {
    }

    public Invoice(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Double getInvAmount() {
        return invAmount;
    }

    public void setInvAmount(Double invAmount) {
        this.invAmount = invAmount;
    }

    public Double getGst() {
        return gst;
    }

    public void setGst(Double gst) {
        this.gst = gst;
    }

    public Double getInvTotal() {
        return invTotal;
    }

    public void setInvTotal(Double invTotal) {
        this.invTotal = invTotal;
    }

    public Date getCreatedDtm() {
        return createdDtm;
    }

    public void setCreatedDtm(Date createdDtm) {
        this.createdDtm = createdDtm;
    }

    public Double getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(Double outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public Boolean getInvoiceSent() {
        return invoiceSent;
    }

    public void setInvoiceSent(Boolean invoiceSent) {
        this.invoiceSent = invoiceSent;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaeetutorial.dukesbookstore.entity.Invoice[ invoiceId=" + invoiceId + " ]";
    }
    
}

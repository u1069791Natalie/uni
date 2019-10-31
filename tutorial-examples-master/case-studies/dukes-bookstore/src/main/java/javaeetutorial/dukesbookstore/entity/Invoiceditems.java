/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.dukesbookstore.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "invoiceditems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoiceditems.findAll", query = "SELECT i FROM Invoiceditems i"),
    @NamedQuery(name = "Invoiceditems.findByInvoiceId", query = "SELECT i FROM Invoiceditems i WHERE i.invoiceditemsPK.invoiceId = :invoiceId"),
    @NamedQuery(name = "Invoiceditems.findBySaleItemId", query = "SELECT i FROM Invoiceditems i WHERE i.invoiceditemsPK.saleItemId = :saleItemId"),
    @NamedQuery(name = "Invoiceditems.findByAmount", query = "SELECT i FROM Invoiceditems i WHERE i.amount = :amount"),
    @NamedQuery(name = "Invoiceditems.findByGst", query = "SELECT i FROM Invoiceditems i WHERE i.gst = :gst"),
    @NamedQuery(name = "Invoiceditems.findByTotal", query = "SELECT i FROM Invoiceditems i WHERE i.total = :total")})
public class Invoiceditems implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvoiceditemsPK invoiceditemsPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Amount")
    private Double amount;
    @Column(name = "Gst")
    private Double gst;
    @Column(name = "Total")
    private Double total;
    @JoinColumn(name = "InvoiceId", referencedColumnName = "InvoiceId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Invoice invoice;
    @JoinColumn(name = "SaleItemId", referencedColumnName = "SaleItemId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sales sales;

    public Invoiceditems() {
    }

    public Invoiceditems(InvoiceditemsPK invoiceditemsPK) {
        this.invoiceditemsPK = invoiceditemsPK;
    }

    public Invoiceditems(int invoiceId, int saleItemId) {
        this.invoiceditemsPK = new InvoiceditemsPK(invoiceId, saleItemId);
    }

    public InvoiceditemsPK getInvoiceditemsPK() {
        return invoiceditemsPK;
    }

    public void setInvoiceditemsPK(InvoiceditemsPK invoiceditemsPK) {
        this.invoiceditemsPK = invoiceditemsPK;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getGst() {
        return gst;
    }

    public void setGst(Double gst) {
        this.gst = gst;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceditemsPK != null ? invoiceditemsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoiceditems)) {
            return false;
        }
        Invoiceditems other = (Invoiceditems) object;
        if ((this.invoiceditemsPK == null && other.invoiceditemsPK != null) || (this.invoiceditemsPK != null && !this.invoiceditemsPK.equals(other.invoiceditemsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaeetutorial.dukesbookstore.entity.Invoiceditems[ invoiceditemsPK=" + invoiceditemsPK + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.dukesbookstore.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author natal
 */
@Embeddable
public class InvoiceditemsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "InvoiceId")
    private int invoiceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SaleItemId")
    private int saleItemId;

    public InvoiceditemsPK() {
    }

    public InvoiceditemsPK(int invoiceId, int saleItemId) {
        this.invoiceId = invoiceId;
        this.saleItemId = saleItemId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(int saleItemId) {
        this.saleItemId = saleItemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) invoiceId;
        hash += (int) saleItemId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceditemsPK)) {
            return false;
        }
        InvoiceditemsPK other = (InvoiceditemsPK) object;
        if (this.invoiceId != other.invoiceId) {
            return false;
        }
        if (this.saleItemId != other.saleItemId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaeetutorial.dukesbookstore.entity.InvoiceditemsPK[ invoiceId=" + invoiceId + ", saleItemId=" + saleItemId + " ]";
    }
    
}

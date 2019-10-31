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
public class BidsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SaleItemId")
    private int saleItemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserId")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BidAmount")
    private double bidAmount;

    public BidsPK() {
    }

    public BidsPK(int saleItemId, int userId, double bidAmount) {
        this.saleItemId = saleItemId;
        this.userId = userId;
        this.bidAmount = bidAmount;
    }

    public int getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(int saleItemId) {
        this.saleItemId = saleItemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) saleItemId;
        hash += (int) userId;
        hash += (int) bidAmount;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BidsPK)) {
            return false;
        }
        BidsPK other = (BidsPK) object;
        if (this.saleItemId != other.saleItemId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (this.bidAmount != other.bidAmount) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaeetutorial.dukesbookstore.entity.BidsPK[ saleItemId=" + saleItemId + ", userId=" + userId + ", bidAmount=" + bidAmount + " ]";
    }
    
}

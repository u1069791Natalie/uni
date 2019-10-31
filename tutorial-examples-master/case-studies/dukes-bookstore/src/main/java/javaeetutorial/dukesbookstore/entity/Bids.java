/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.dukesbookstore.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author natal
 */
@Entity
@Table(name = "bids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bids.findAll", query = "SELECT b FROM Bids b"),
    @NamedQuery(name = "Bids.findBySaleItemId", query = "SELECT b FROM Bids b WHERE b.bidsPK.saleItemId = :saleItemId"),
    @NamedQuery(name = "Bids.findByUserId", query = "SELECT b FROM Bids b WHERE b.bidsPK.userId = :userId"),
    @NamedQuery(name = "Bids.findByBidAmount", query = "SELECT b FROM Bids b WHERE b.bidsPK.bidAmount = :bidAmount"),
    @NamedQuery(name = "Bids.findByBidDtm", query = "SELECT b FROM Bids b WHERE b.bidDtm = :bidDtm")})
public class Bids implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BidsPK bidsPK;
    @Column(name = "BidDtm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bidDtm;
    @JoinColumn(name = "SaleItemId", referencedColumnName = "SaleItemId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Saleitem saleitem;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Bids() {
    }

    public Bids(BidsPK bidsPK) {
        this.bidsPK = bidsPK;
    }

    public Bids(int saleItemId, int userId, double bidAmount) {
        this.bidsPK = new BidsPK(saleItemId, userId, bidAmount);
    }

    public BidsPK getBidsPK() {
        return bidsPK;
    }

    public void setBidsPK(BidsPK bidsPK) {
        this.bidsPK = bidsPK;
    }

    public Date getBidDtm() {
        return bidDtm;
    }

    public void setBidDtm(Date bidDtm) {
        this.bidDtm = bidDtm;
    }

    public Saleitem getSaleitem() {
        return saleitem;
    }

    public void setSaleitem(Saleitem saleitem) {
        this.saleitem = saleitem;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bidsPK != null ? bidsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bids)) {
            return false;
        }
        Bids other = (Bids) object;
        if ((this.bidsPK == null && other.bidsPK != null) || (this.bidsPK != null && !this.bidsPK.equals(other.bidsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaeetutorial.dukesbookstore.entity.Bids[ bidsPK=" + bidsPK + " ]";
    }
    
}

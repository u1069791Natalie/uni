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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "saleitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saleitem.findAll", query = "SELECT s FROM Saleitem s"),
    @NamedQuery(name = "Saleitem.findBySaleItemId", query = "SELECT s FROM Saleitem s WHERE s.saleItemId = :saleItemId"),
    @NamedQuery(name = "Saleitem.findByPrice", query = "SELECT s FROM Saleitem s WHERE s.price = :price"),
    @NamedQuery(name = "Saleitem.findByBidPrice", query = "SELECT s FROM Saleitem s WHERE s.bidPrice = :bidPrice"),
    @NamedQuery(name = "Saleitem.findByTradeAvailable", query = "SELECT s FROM Saleitem s WHERE s.tradeAvailable = :tradeAvailable"),
    @NamedQuery(name = "Saleitem.findByListDate", query = "SELECT s FROM Saleitem s WHERE s.listDate = :listDate")})
public class Saleitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SaleItemId")
    private Integer saleItemId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private Double price;
    @Column(name = "BidPrice")
    private Double bidPrice;
    @Column(name = "TradeAvailable")
    private Boolean tradeAvailable;
    @Column(name = "ListDate")
    @Temporal(TemporalType.DATE)
    private Date listDate;
    @JoinTable(name = "users_saleitem", joinColumns = {
        @JoinColumn(name = "SaleItemId", referencedColumnName = "SaleItemId")}, inverseJoinColumns = {
        @JoinColumn(name = "UserId", referencedColumnName = "UserId")})
    @ManyToMany
    private Collection<Users> usersCollection;
    @ManyToMany(mappedBy = "saleitemCollection")
    private Collection<Images> imagesCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "saleitem")
    private Sales sales;
    @OneToOne(mappedBy = "tradedSaleItemId")
    private Sales sales1;
    @JoinColumn(name = "BookId", referencedColumnName = "BookId")
    @ManyToOne
    private Book bookId;
    @JoinColumn(name = "SaleTypeId", referencedColumnName = "SaleTypeId")
    @ManyToOne
    private Saletype saleTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saleitem")
    private Collection<Bids> bidsCollection;

    public Saleitem() {
    }

    public Saleitem(Integer saleItemId) {
        this.saleItemId = saleItemId;
    }

    public Integer getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(Integer saleItemId) {
        this.saleItemId = saleItemId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Boolean getTradeAvailable() {
        return tradeAvailable;
    }

    public void setTradeAvailable(Boolean tradeAvailable) {
        this.tradeAvailable = tradeAvailable;
    }

    public Date getListDate() {
        return listDate;
    }

    public void setListDate(Date listDate) {
        this.listDate = listDate;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @XmlTransient
    public Collection<Images> getImagesCollection() {
        return imagesCollection;
    }

    public void setImagesCollection(Collection<Images> imagesCollection) {
        this.imagesCollection = imagesCollection;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Sales getSales1() {
        return sales1;
    }

    public void setSales1(Sales sales1) {
        this.sales1 = sales1;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Saletype getSaleTypeId() {
        return saleTypeId;
    }

    public void setSaleTypeId(Saletype saleTypeId) {
        this.saleTypeId = saleTypeId;
    }

    @XmlTransient
    public Collection<Bids> getBidsCollection() {
        return bidsCollection;
    }

    public void setBidsCollection(Collection<Bids> bidsCollection) {
        this.bidsCollection = bidsCollection;
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
        if (!(object instanceof Saleitem)) {
            return false;
        }
        Saleitem other = (Saleitem) object;
        if ((this.saleItemId == null && other.saleItemId != null) || (this.saleItemId != null && !this.saleItemId.equals(other.saleItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaeetutorial.dukesbookstore.entity.Saleitem[ saleItemId=" + saleItemId + " ]";
    }
    
}

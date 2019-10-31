/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.dukesbookstore.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "servicecosts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicecosts.findAll", query = "SELECT s FROM Servicecosts s"),
    @NamedQuery(name = "Servicecosts.findBySaleTypeId", query = "SELECT s FROM Servicecosts s WHERE s.saleTypeId = :saleTypeId"),
    @NamedQuery(name = "Servicecosts.findByDescrption", query = "SELECT s FROM Servicecosts s WHERE s.descrption = :descrption"),
    @NamedQuery(name = "Servicecosts.findByFlatFee", query = "SELECT s FROM Servicecosts s WHERE s.flatFee = :flatFee"),
    @NamedQuery(name = "Servicecosts.findByPercentage", query = "SELECT s FROM Servicecosts s WHERE s.percentage = :percentage"),
    @NamedQuery(name = "Servicecosts.findByAdFee", query = "SELECT s FROM Servicecosts s WHERE s.adFee = :adFee")})
public class Servicecosts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SaleTypeId")
    private Integer saleTypeId;
    @Size(max = 200)
    @Column(name = "Descrption")
    private String descrption;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FlatFee")
    private Double flatFee;
    @Column(name = "Percentage")
    private Double percentage;
    @Column(name = "AdFee")
    private Integer adFee;
    @JoinColumn(name = "SaleTypeId", referencedColumnName = "SaleTypeId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Saletype saletype;

    public Servicecosts() {
    }

    public Servicecosts(Integer saleTypeId) {
        this.saleTypeId = saleTypeId;
    }

    public Integer getSaleTypeId() {
        return saleTypeId;
    }

    public void setSaleTypeId(Integer saleTypeId) {
        this.saleTypeId = saleTypeId;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Double getFlatFee() {
        return flatFee;
    }

    public void setFlatFee(Double flatFee) {
        this.flatFee = flatFee;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Integer getAdFee() {
        return adFee;
    }

    public void setAdFee(Integer adFee) {
        this.adFee = adFee;
    }

    public Saletype getSaletype() {
        return saletype;
    }

    public void setSaletype(Saletype saletype) {
        this.saletype = saletype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleTypeId != null ? saleTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicecosts)) {
            return false;
        }
        Servicecosts other = (Servicecosts) object;
        if ((this.saleTypeId == null && other.saleTypeId != null) || (this.saleTypeId != null && !this.saleTypeId.equals(other.saleTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaeetutorial.dukesbookstore.entity.Servicecosts[ saleTypeId=" + saleTypeId + " ]";
    }
    
}

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "fees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fees.findAll", query = "SELECT f FROM Fees f"),
    @NamedQuery(name = "Fees.findByFeeId", query = "SELECT f FROM Fees f WHERE f.feeId = :feeId"),
    @NamedQuery(name = "Fees.findByDescrption", query = "SELECT f FROM Fees f WHERE f.descrption = :descrption"),
    @NamedQuery(name = "Fees.findByPercent", query = "SELECT f FROM Fees f WHERE f.percent = :percent"),
    @NamedQuery(name = "Fees.findByFlatFee", query = "SELECT f FROM Fees f WHERE f.flatFee = :flatFee")})
public class Fees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FeeId")
    private Integer feeId;
    @Size(max = 100)
    @Column(name = "Descrption")
    private String descrption;
    @Column(name = "Percent")
    private Integer percent;
    @Column(name = "FlatFee")
    private Integer flatFee;

    public Fees() {
    }

    public Fees(Integer feeId) {
        this.feeId = feeId;
    }

    public Integer getFeeId() {
        return feeId;
    }

    public void setFeeId(Integer feeId) {
        this.feeId = feeId;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Integer getFlatFee() {
        return flatFee;
    }

    public void setFlatFee(Integer flatFee) {
        this.flatFee = flatFee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feeId != null ? feeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fees)) {
            return false;
        }
        Fees other = (Fees) object;
        if ((this.feeId == null && other.feeId != null) || (this.feeId != null && !this.feeId.equals(other.feeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaeetutorial.dukesbookstore.entity.Fees[ feeId=" + feeId + " ]";
    }
    
}

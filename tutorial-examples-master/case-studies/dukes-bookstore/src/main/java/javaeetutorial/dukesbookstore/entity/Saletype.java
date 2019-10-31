/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.dukesbookstore.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "saletype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saletype.findAll", query = "SELECT s FROM Saletype s"),
    @NamedQuery(name = "Saletype.findBySaleTypeId", query = "SELECT s FROM Saletype s WHERE s.saleTypeId = :saleTypeId"),
    @NamedQuery(name = "Saletype.findByDescription", query = "SELECT s FROM Saletype s WHERE s.description = :description")})
public class Saletype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SaleTypeId")
    private Integer saleTypeId;
    @Size(max = 100)
    @Column(name = "Description")
    private String description;
    @OneToMany(mappedBy = "saleTypeId")
    private Collection<Saleitem> saleitemCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "saletype")
    private Servicecosts servicecosts;

    public Saletype() {
    }

    public Saletype(Integer saleTypeId) {
        this.saleTypeId = saleTypeId;
    }

    public Integer getSaleTypeId() {
        return saleTypeId;
    }

    public void setSaleTypeId(Integer saleTypeId) {
        this.saleTypeId = saleTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Saleitem> getSaleitemCollection() {
        return saleitemCollection;
    }

    public void setSaleitemCollection(Collection<Saleitem> saleitemCollection) {
        this.saleitemCollection = saleitemCollection;
    }

    public Servicecosts getServicecosts() {
        return servicecosts;
    }

    public void setServicecosts(Servicecosts servicecosts) {
        this.servicecosts = servicecosts;
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
        if (!(object instanceof Saletype)) {
            return false;
        }
        Saletype other = (Saletype) object;
        if ((this.saleTypeId == null && other.saleTypeId != null) || (this.saleTypeId != null && !this.saleTypeId.equals(other.saleTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaeetutorial.dukesbookstore.entity.Saletype[ saleTypeId=" + saleTypeId + " ]";
    }
    
}

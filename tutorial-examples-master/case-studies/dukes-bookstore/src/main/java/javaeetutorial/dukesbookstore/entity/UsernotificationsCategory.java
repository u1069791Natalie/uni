/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.dukesbookstore.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author natal
 */
@Entity
@Table(name = "usernotifications_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsernotificationsCategory.findAll", query = "SELECT u FROM UsernotificationsCategory u"),
    @NamedQuery(name = "UsernotificationsCategory.findByUserId", query = "SELECT u FROM UsernotificationsCategory u WHERE u.usernotificationsCategoryPK.userId = :userId"),
    @NamedQuery(name = "UsernotificationsCategory.findByCategoryId", query = "SELECT u FROM UsernotificationsCategory u WHERE u.usernotificationsCategoryPK.categoryId = :categoryId")})
public class UsernotificationsCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsernotificationsCategoryPK usernotificationsCategoryPK;
    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Category category;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public UsernotificationsCategory() {
    }

    public UsernotificationsCategory(UsernotificationsCategoryPK usernotificationsCategoryPK) {
        this.usernotificationsCategoryPK = usernotificationsCategoryPK;
    }

    public UsernotificationsCategory(int userId, int categoryId) {
        this.usernotificationsCategoryPK = new UsernotificationsCategoryPK(userId, categoryId);
    }

    public UsernotificationsCategoryPK getUsernotificationsCategoryPK() {
        return usernotificationsCategoryPK;
    }

    public void setUsernotificationsCategoryPK(UsernotificationsCategoryPK usernotificationsCategoryPK) {
        this.usernotificationsCategoryPK = usernotificationsCategoryPK;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        hash += (usernotificationsCategoryPK != null ? usernotificationsCategoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsernotificationsCategory)) {
            return false;
        }
        UsernotificationsCategory other = (UsernotificationsCategory) object;
        if ((this.usernotificationsCategoryPK == null && other.usernotificationsCategoryPK != null) || (this.usernotificationsCategoryPK != null && !this.usernotificationsCategoryPK.equals(other.usernotificationsCategoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaeetutorial.dukesbookstore.entity.UsernotificationsCategory[ usernotificationsCategoryPK=" + usernotificationsCategoryPK + " ]";
    }
    
}

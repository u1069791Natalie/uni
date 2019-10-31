/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.dukesbookstore.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Book.findBySurname", query = "SELECT b FROM Book b WHERE b.surname = :surname"),
    @NamedQuery(name = "Book.findByFirstname", query = "SELECT b FROM Book b WHERE b.firstname = :firstname"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByPrice", query = "SELECT b FROM Book b WHERE b.price = :price"),
    @NamedQuery(name = "Book.findByOnsale", query = "SELECT b FROM Book b WHERE b.onsale = :onsale"),
    @NamedQuery(name = "Book.findByCalendarYear", query = "SELECT b FROM Book b WHERE b.calendarYear = :calendarYear"),
    @NamedQuery(name = "Book.findByDescription", query = "SELECT b FROM Book b WHERE b.description = :description"),
    @NamedQuery(name = "Book.findByInventory", query = "SELECT b FROM Book b WHERE b.inventory = :inventory")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BookId")
    private Integer bookId;
    @Size(max = 100)
    @Column(name = "Isbn")
    private String isbn;
    @Size(max = 100)
    @Column(name = "Surname")
    private String surname;
    @Size(max = 100)
    @Column(name = "Firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Title")
    private String title;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private Double price;
    @Column(name = "Onsale")
    private Boolean onsale;
    @Column(name = "CalendarYear")
    private Integer calendarYear;
    @Size(max = 100)
    @Column(name = "Description")
    private String description;
    @Column(name = "Inventory")
    private Integer inventory;
    @JoinTable(name = "usernotifications_book", joinColumns = {
        @JoinColumn(name = "BookId", referencedColumnName = "BookId")}, inverseJoinColumns = {
        @JoinColumn(name = "UserId", referencedColumnName = "UserId")})
    @ManyToMany
    private Collection<Users> usersCollection;
    @JoinColumn(name = "SubCategoryId", referencedColumnName = "SubCategoryId")
    @ManyToOne
    private Subcategory subCategoryId;
    @OneToMany(mappedBy = "bookId")
    private Collection<Saleitem> saleitemCollection;

    public Book() {
    }

    public Book(Integer bookId) {
        this.bookId = bookId;
    }

    public Book(Integer bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }
    
    public Book(String isbn, String surname, String firstname, String title,
            Double price, Boolean onsale, Integer calendarYear,
            String description, Integer inventory) {
        this.isbn = isbn;
        this.surname = surname;
        this.firstname = firstname;
        this.title = title;
        this.price = price;
        this.onsale = onsale;
        this.calendarYear = calendarYear;
        this.description = description;
        this.inventory = inventory;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getOnsale() {
        return onsale;
    }

    public void setOnsale(Boolean onsale) {
        this.onsale = onsale;
    }

    public Integer getCalendarYear() {
        return calendarYear;
    }

    public void setCalendarYear(Integer calendarYear) {
        this.calendarYear = calendarYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Subcategory getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Subcategory subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    @XmlTransient
    public Collection<Saleitem> getSaleitemCollection() {
        return saleitemCollection;
    }

    public void setSaleitemCollection(Collection<Saleitem> saleitemCollection) {
        this.saleitemCollection = saleitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaeetutorial.dukesbookstore.entity.Book[ bookId=" + bookId + " ]";
    }
    
}

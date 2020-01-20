package com.spring.example.springdbviews.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "view_customer")
@Immutable
/*
 * If your Domain Model requires that a given entity should not be modified
 * by the data access logic, Hibernate can enforce this requirement if the entity
 * is marked with the @Immutable annotation.
 */
@SecondaryTables(
        @SecondaryTable(name = "view_address",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "identifier"))
)
public class Customer {

    @Id
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name", table = "view_address", insertable = false, updatable = false)),
            @AttributeOverride(name = "building", column = @Column(name = "building", table = "view_address", insertable = false, updatable = false)),
            @AttributeOverride(name = "street", column = @Column(name = "street", table = "view_address", insertable = false, updatable = false)),
            @AttributeOverride(name = "country", column = @Column(name = "country", table = "view_address", insertable = false, updatable = false))
    })
    private Address address;

    //TODO : change the  fetch to lazy. at the moment we have this error : failed to lazily initialize a collection of role: org.spring.tutorial.examples.jpa.databaseviews.entity.Customer.accounts, could not initialize proxy - no Session
    @ElementCollection(fetch = FetchType.EAGER)
    /*
     * JPA 2.0 defines an ElementCollection mapping. It is meant to handle several non-standard relationship mappings. An ElementCollection can be used to
     * define a one-to-many relationship to an Embeddable object.
     */
    @CollectionTable(
            name = "view_account",
            joinColumns = @JoinColumn(name = "identifier")
    )
    private List<Account> accounts;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}

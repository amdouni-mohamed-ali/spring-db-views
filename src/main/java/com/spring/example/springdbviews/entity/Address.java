package com.spring.example.springdbviews.entity;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
/*
 * We use JPA’s @Embeddable annotation to declare that a class is meant to be embedded by other entities.
 */
public class Address {

    /*
     * check this post :
     * https://www.callicoder.com/hibernate-spring-boot-jpa-embeddable-demo/
     */
    private String firstName;
    private String building;
    private String street;
    private String country;

    public String getFirstName() {
        return firstName;
    }

    public Address setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getBuilding() {
        return building;
    }

    public Address setBuilding(String building) {
        this.building = building;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public String toString() {
        return "Address{" +
                "firstName='" + firstName + '\'' +
                ", building='" + building + '\'' +
                ", street='" + street + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(firstName, address.firstName) &&
                Objects.equals(building, address.building) &&
                Objects.equals(street, address.street) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, building, street, country);
    }
}

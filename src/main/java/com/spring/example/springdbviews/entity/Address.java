package com.spring.example.springdbviews.entity;

import javax.persistence.Embeddable;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
}

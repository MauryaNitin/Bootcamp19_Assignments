package com.ttn.hibernateDemo.entity;


import javax.persistence.Embeddable;

/**
 * Ques 10: Create a class Address for AuthorUOTM with instance variables streetNumber, location, State.
 */

@Embeddable
public class Address {
    private String streetNumber;
    private String location;
    private String state;

    public Address(String streetNumber, String location, String state) {
        this.streetNumber = streetNumber;
        this.location = location;
        this.state = state;
    }

    public Address(){

    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

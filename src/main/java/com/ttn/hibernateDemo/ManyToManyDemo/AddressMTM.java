package com.ttn.hibernateDemo.ManyToManyDemo;


import javax.persistence.Embeddable;

/**
 * Ques 10: Create a class AddressMTM for AuthorMTM with instance variables streetNumber, location, State.
 */

@Embeddable
public class AddressMTM {
    private String streetNumber;
    private String location;
    private String state;

    public AddressMTM(String streetNumber, String location, String state) {
        this.streetNumber = streetNumber;
        this.location = location;
        this.state = state;
    }

    public AddressMTM(){

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

package com.sparta.trainingdatabase.model.entity.inspection;

import lombok.Data;

@Data
public class Address {
    private String city;
    private String zip;
    private String street;
    private String number;

    public Address(String city, String zip, String street, String number) {
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

package com.tdc.cleancode.dto;

import java.util.Optional;

public class AddressWithOptional {

    private String street;
    private String number;
    private String complement;
    private String postalCode;
    private CityWithOptional city;

    public AddressWithOptional() {
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

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Optional<CityWithOptional> getCity() {
        return Optional.ofNullable(city);
    }

    public void setCity(CityWithOptional city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "AddressWithOptional{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}

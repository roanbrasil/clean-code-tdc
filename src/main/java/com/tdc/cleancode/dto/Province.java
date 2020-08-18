package com.tdc.cleancode.dto;

public class Province {

    private String name;
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}

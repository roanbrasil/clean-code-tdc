package com.tdc.cleancode.dto;

import java.util.Optional;

public class ProvinceWithOptional {

    private String name;
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Country> getCountry() {
        return Optional.ofNullable(country);
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ProvinceWithOptional{" +
                "name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}

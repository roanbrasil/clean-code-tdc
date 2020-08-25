package com.tdc.cleancode.complex.dto;

import java.util.List;

public class PaymentDataStream {

    private String country;
    private ComplexGroup complexGroup;

    public PaymentDataStream() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ComplexGroup getComplexGroup() {
        return complexGroup;
    }

    public void setComplexGroup(ComplexGroup complexGroup) {
        this.complexGroup = complexGroup;
    }

    @Override
    public String toString() {
        return "ComplexDataStreamExample{" +
                "country='" + country + '\'' +
                ", complexGroup=" + complexGroup +
                '}';
    }
}

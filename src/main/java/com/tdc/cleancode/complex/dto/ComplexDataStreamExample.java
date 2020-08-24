package com.tdc.cleancode.complex.dto;

import java.util.List;

public class ComplexDataStreamExample {

    private String country;
    private List<ComplexGroup> complexGroupList;

    public ComplexDataStreamExample() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<ComplexGroup> getComplexGroupList() {
        return complexGroupList;
    }

    public void setComplexGroupList(List<ComplexGroup> complexGroupList) {
        this.complexGroupList = complexGroupList;
    }

    @Override
    public String toString() {
        return "ComplexDataStreamExample{" +
                "country='" + country + '\'' +
                ", complexGroupList=" + complexGroupList +
                '}';
    }
}

package com.tdc.cleancode.dto;

public class City {

    private String name;
    private Province province;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", province=" + province +
                '}';
    }
}

package com.tdc.cleancode.dto;

import java.util.Optional;

public class CityWithOptional {

    private String name;
    private ProvinceWithOptional province;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<ProvinceWithOptional> getProvince() {
        return Optional.ofNullable(province);
    }

    public void setProvince(ProvinceWithOptional province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "CityWithOptional{" +
                "name='" + name + '\'' +
                ", province=" + province +
                '}';
    }
}

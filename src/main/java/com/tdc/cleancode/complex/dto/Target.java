package com.tdc.cleancode.complex.dto;


import java.util.List;

public class Target {

    private Long id;
    private String name;
    private List<SimpleValue> simpleValueList;

    public Target() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long ind) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SimpleValue> getSimpleValueList() {
        return simpleValueList;
    }

    public void setSimpleValueList(List<SimpleValue> simpleValueList) {
        this.simpleValueList = simpleValueList;
    }

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", simpleValueList=" + simpleValueList +
                '}';
    }
}

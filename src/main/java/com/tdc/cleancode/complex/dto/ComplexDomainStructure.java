package com.tdc.cleancode.complex.dto;

import java.util.List;

public class ComplexDomainStructure {

    private Long id;
    private List<SimpleValue> simpleValueList;
    private Target target;

    public ComplexDomainStructure() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SimpleValue> getSimpleValueList() {
        return simpleValueList;
    }

    public void setSimpleValueList(List<SimpleValue> simpleValueList) {
        this.simpleValueList = simpleValueList;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "ComplexDomainStructure{" +
                "id=" + id +
                ", simpleValueList=" + simpleValueList +
                ", target=" + target +
                '}';
    }
}

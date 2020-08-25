package com.tdc.cleancode.complex.dto;

import java.util.List;

public class ComplexDomainStructure {

    private Long id;
    private List<SimpleValue> simpleValues;
    private Target target;

    public ComplexDomainStructure() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SimpleValue> getSimpleValues() {
        return simpleValues;
    }

    public void setSimpleValues(List<SimpleValue> simpleValues) {
        this.simpleValues = simpleValues;
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
                ", simpleValues=" + simpleValues +
                ", target=" + target +
                '}';
    }
}

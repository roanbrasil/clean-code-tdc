package com.tdc.cleancode.complex.dto;

public class SimpleValue {

    private String attributeName;
    private String attributeValue;

    public SimpleValue() {
    }

    public SimpleValue(String attributeName, String attributeValue) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    @Override
    public String toString() {
        return "SimpleValue{" +
                "attributeName='" + attributeName + '\'' +
                ", attributeValue='" + attributeValue + '\'' +
                '}';
    }
}

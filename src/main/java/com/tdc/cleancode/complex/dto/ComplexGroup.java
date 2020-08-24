package com.tdc.cleancode.complex.dto;

import java.util.List;

public class ComplexGroup {

    private String listName;
    private List<Complex> complexList;

    public ComplexGroup() {
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Complex> getComplexList() {
        return complexList;
    }

    public void setComplexList(List<Complex> complexList) {
        this.complexList = complexList;
    }

    @Override
    public String toString() {
        return "ComplexGroup{" +
                "listName='" + listName + '\'' +
                ", complexList=" + complexList +
                '}';
    }
}

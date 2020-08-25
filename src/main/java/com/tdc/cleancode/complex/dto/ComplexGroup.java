package com.tdc.cleancode.complex.dto;

import java.util.List;

public class ComplexGroup {

    private String listName;
    private List<Complex> complexes;

    public ComplexGroup() {
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Complex> getComplexes() {
        return complexes;
    }

    public void setComplexes(List<Complex> complexes) {
        this.complexes = complexes;
    }

    @Override
    public String toString() {
        return "ComplexGroup{" +
                "listName='" + listName + '\'' +
                ", complexList=" + complexes +
                '}';
    }
}

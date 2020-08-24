package com.tdc.cleancode.complex.dto;

import java.time.LocalDate;

public class Complex {

    private LocalDate registerDate;
    private LocalDate endDate;
    private ComplexDomainStructure complexDomainStructure;

    public Complex() {
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public ComplexDomainStructure getComplexDomainStructure() {
        return complexDomainStructure;
    }

    public void setComplexDomainStructure(ComplexDomainStructure complexDomainStructure) {
        this.complexDomainStructure = complexDomainStructure;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "registerDate=" + registerDate +
                ", endDate=" + endDate +
                ", complexDomainStructure=" + complexDomainStructure +
                '}';
    }
}

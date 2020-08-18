package com.tdc.cleancode.dto;

import java.math.BigDecimal;
import java.util.Optional;

public class EmployeeWithOptional {

    private String name;
    private String age;
    private BigDecimal salary;
    private AddressWithOptional address;

    public EmployeeWithOptional() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Optional<AddressWithOptional> getAddress() {
        return Optional.ofNullable(address);
    }

    public void setAddress(AddressWithOptional address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeWithOptional{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                ", address=" + address +
                '}';
    }
}

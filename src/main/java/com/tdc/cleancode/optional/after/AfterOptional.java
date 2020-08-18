package com.tdc.cleancode.optional.after;

import com.tdc.cleancode.dto.*;
import com.tdc.cleancode.optional.before.BeforeOptional;

import java.math.BigDecimal;
import java.util.Optional;

public class AfterOptional {

    private void printCountry(EmployeeWithOptional employee) {
        String countryName = Optional.of(employee)
                .flatMap(EmployeeWithOptional::getAddress)
                .flatMap(AddressWithOptional::getCity)
                .flatMap(CityWithOptional::getProvince)
                .flatMap(ProvinceWithOptional::getCountry)
                .map(Country::getName)
                .orElse("UnKnown");

        System.out.println("The country's name is: " +countryName);
    }

    public static void main(String[] args) {
        Country country = new Country();
        country.setName("Canada");

        ProvinceWithOptional province = new ProvinceWithOptional();
        province.setName("Quebec");
        province.setCountry(country);

        CityWithOptional city = new CityWithOptional();
        city.setName("Montreal");
        city.setProvince(province);

        AddressWithOptional address = new AddressWithOptional();
        address.setCity(city);
        address.setPostalCode("H1T 3X1");
        address.setNumber("5199");
        address.setStreet("Rue Sherbrooke Est");

        EmployeeWithOptional employee = new EmployeeWithOptional();
        employee.setName("Roan Brasil Monteiro");
        employee.setAge("35");
        employee.setSalary(BigDecimal.valueOf(1.00));
        employee.setAddress(address);

        AfterOptional afterOptional = new AfterOptional();
        afterOptional.printCountry(employee);
    }
}

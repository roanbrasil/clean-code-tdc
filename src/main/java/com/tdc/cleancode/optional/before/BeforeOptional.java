package com.tdc.cleancode.optional.before;

import com.tdc.cleancode.dto.*;

import java.math.BigDecimal;
import java.util.Objects;

public class BeforeOptional {

    private void printCountry(Employee employee){
        if(Objects.nonNull(employee)) {
            Address address = employee.getAddress();
            if(Objects.nonNull(address)) {
                City city = address.getCity();
                if(Objects.nonNull(city)){
                    Province province = city.getProvince();
                    if(Objects.nonNull(province)){
                        Country country = province.getCountry();
                        if(Objects.nonNull(country)){
                            System.out.println("The country's name is: " + country.getName());
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Country country = new Country();
        country.setName("Canada");

        Province province = new Province();
        province.setName("Quebec");
        province.setCountry(country);

        City city = new City();
        city.setName("Montreal");
        city.setProvince(province);

        Address address = new Address();
        address.setCity(city);
        address.setPostalCode("H1T 3X1");
        address.setNumber("5199");
        address.setStreet("Rue Sherbrooke Est");

        Employee employee = new Employee();
        employee.setName("Roan Brasil Monteiro");
        employee.setAge("35");
        employee.setSalary(BigDecimal.valueOf(1.00));
        employee.setAddress(address);

        BeforeOptional beforeOptional = new BeforeOptional();
        beforeOptional.printCountry(employee);

    }
}

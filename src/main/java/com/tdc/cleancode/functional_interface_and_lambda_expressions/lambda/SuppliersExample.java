package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda;

import com.tdc.cleancode.dto.Country;

import java.util.List;
import java.util.function.Supplier;

public class SuppliersExample {

    public void generateSupplierStringBuilder() {

        Supplier<StringBuilder> sup = () -> new StringBuilder("Montreal");

        System.out.println((sup.get().toString()));
    }

    public void generateSupplierEmptyStringBuilder() {

        Supplier<StringBuilder> sup = StringBuilder::new;

        System.out.println(sup.get().toString());
    }

    public void printCountry() {

        Supplier<Country> sup = Country::new;

        System.out.println(sup.get().toString());
    }

    public void createThreeCountries() {

        CountryFactory countryFactory = Country::new;

        List<Country> countries = countryFactory.getThree();

        System.out.println(countries);

        CountryFactory countryFactory2 = () -> new Country("Canada");

        List<Country> countries2 = countryFactory2.getThree();

        System.out.println(countries2);

    }

    public void createThreeCountriesByFactoryCreator() {

        CountryFactory countryFactory = CountryFactory.createFactory(Country::new);

        List<Country> countries = countryFactory.getThree();

        System.out.println(countries);

        CountryFactory countryFactory2 = CountryFactory.createFactory(Country::new, "Brazil");

        List<Country> countries2 = countryFactory2.getThree();

        System.out.println(countries2);
    }

    public static void main(String[] args) {
        SuppliersExample suppliersExample = new SuppliersExample();
        suppliersExample.generateSupplierStringBuilder();

        suppliersExample.generateSupplierEmptyStringBuilder();

        suppliersExample.printCountry();

        suppliersExample.createThreeCountries();

        suppliersExample.createThreeCountriesByFactoryCreator();

    }
}

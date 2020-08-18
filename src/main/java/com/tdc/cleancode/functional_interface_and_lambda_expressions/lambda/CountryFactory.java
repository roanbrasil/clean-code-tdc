package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda;

import com.tdc.cleancode.dto.Country;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface CountryFactory extends Supplier<Country> {

    default List<Country> getThree() {
        return IntStream.range(0, 3).mapToObj(index -> get()).collect(Collectors.toList());
    }

    static CountryFactory createFactory(Supplier<Country> countrySupplier) {
        return countrySupplier::get;
    }

    static CountryFactory createFactory(Function<String, Country> constructor, String name) {
        return () -> constructor.apply(name);
    }
}

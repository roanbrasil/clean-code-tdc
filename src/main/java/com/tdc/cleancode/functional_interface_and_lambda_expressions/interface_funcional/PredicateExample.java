package com.tdc.cleancode.functional_interface_and_lambda_expressions.interface_funcional;

import java.util.Arrays;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    private final List<String> names = Arrays.asList("Roan", "Paula", "Otavio", "Rafael");

    public void verifyNamesStartingWithR(){
        Predicate<String> predicate = (name)-> name.startsWith("R");

        names.stream()
                .filter(predicate)
                .forEach(System.out::println);

        names.stream()
                .filter(name -> name.startsWith("R"))
                .forEach(System.out::println);

    }

    public static void main(String[] args) {
        PredicateExample predicateExample = new PredicateExample();
        predicateExample.verifyNamesStartingWithR();
    }
}

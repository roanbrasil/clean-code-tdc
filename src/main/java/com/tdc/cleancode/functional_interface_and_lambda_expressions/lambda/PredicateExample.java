package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda;

import java.util.Arrays;

import java.util.List;
import java.util.Objects;
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

    public void testIfStringIsNull() {

        Predicate<String> stringPredicate = Objects::isNull;

        System.out.println("Valid if it is NULL: " + stringPredicate.test(null));
        System.out.println("Valid if it is NULL with Empty Value: " + stringPredicate.test(""));
    }

    public void testIfStringIsEmpty() {

        Predicate<String> stringPredicate = String::isEmpty;

        System.out.println("Valid if it is Empty: " + stringPredicate.test(""));
        System.out.println("Valid if it is Empty with a value: "+ stringPredicate.test("Quebec"));
    }

    public void testIfStringIsNonNull() {

        Predicate<String> stringPredicate = Objects::isNull;

        Predicate<String> stringPredicateNegate = stringPredicate.negate();

        System.out.println("Valid if it is Non-NULL with Empty value: " + stringPredicateNegate.test(""));
        System.out.println("Valid if it is Non-NULL: " + stringPredicateNegate.test(null));
    }

    public void testIfStringIsNullOrEmpty() {

        Predicate<String> stringPredicateNull = Objects::isNull;
        Predicate<String> stringPredicateEmpty = String::isEmpty;

        Predicate<String> stringPredicateNullOrEmpty = stringPredicateNull.or(stringPredicateEmpty);

        System.out.println("Valid if it is NULL or Empty: " + stringPredicateNullOrEmpty.test(""));
        System.out.println("Valid if it is NULL or Empty: " + stringPredicateNullOrEmpty.test(null));
        System.out.println("Valid if it is NULL or Empty: " + stringPredicateNullOrEmpty.test("Canada"));
    }

    public void testIfStringIsNonNullAndNonEmpty() {

        Predicate<String> stringPredicateNull = Objects::isNull;
        Predicate<String> stringPredicateEmpty = String::isEmpty;

        Predicate<String> stringPredicateNullOrEmpty = stringPredicateNull.or(stringPredicateEmpty).negate();

        System.out.println("Validating if String is NonNull and NonEmpty: " +stringPredicateNullOrEmpty.test(""));
        System.out.println("Validating if String is NonNull and NonEmpty: " +stringPredicateNullOrEmpty.test(null));
        System.out.println("Validating if String is NonNull and NonEmpty: " +stringPredicateNullOrEmpty.test("Hello"));
    }


    public void validateStringSize() {

        Predicate<String> stringPredicateSizeValidation = s -> s.length() < 6;

        System.out.println("Validating if string size is smaller than 6: " + stringPredicateSizeValidation.test("Roan"));
        System.out.println("Validating if string size is smaller than 6: " + stringPredicateSizeValidation.test("Paula"));
        System.out.println("Validating if string size is smaller than 6: " + stringPredicateSizeValidation.test("Otavio"));
    }


    public void validateIfStringValueIsERROR() {

        Predicate<String> equalsError = "ERROR"::equals;

        System.out.println("Validating if string value is ERROR: " + equalsError.test("Hello"));
        System.out.println("Validating if string value is ERROR: " + equalsError.test("ERROR"));
        System.out.println("Validating if string value is ERROR: " + equalsError.test(null));
    }

    public static void main(String[] args) {
        PredicateExample predicateExample = new PredicateExample();
        predicateExample.verifyNamesStartingWithR();

        predicateExample.testIfStringIsNull();

        predicateExample.testIfStringIsEmpty();

        predicateExample.testIfStringIsNonNull();

        predicateExample.testIfStringIsNullOrEmpty();

        predicateExample.testIfStringIsNonNullAndNonEmpty();

        predicateExample.validateStringSize();

        predicateExample.validateIfStringValueIsERROR();

    }
}

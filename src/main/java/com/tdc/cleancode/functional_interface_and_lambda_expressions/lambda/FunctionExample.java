package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {

    public void upperCaseConversion() {

        Function<String, String> functionUpperCaseConversion = String::toUpperCase;

        System.out.println("UpperCase conversion: " + functionUpperCaseConversion.apply("Canada"));
    }


    public void wrapWithParentheses() {

        Function<String, String> functionWrapWithParentheses = s -> "(" + s + ")";

        System.out.println("UpperCase conversion: " + functionWrapWithParentheses.apply("Flamengo"));
    }

    public void getStringLength() {

        Function<String, Integer> functionStringLength = String::length;

        System.out.println("Get String Length: " + functionStringLength.apply(""));
        System.out.println("Get String Length: " + functionStringLength.apply("Nothing"));
    }

    public void validateIfStringIsNullOrNot() {

        Function<String, String> functionValidatingIfStringIsNullOrNot = s -> s == null ? "" : s;

        System.out.println("Validate If String is Null Or Not: " + functionValidatingIfStringIsNullOrNot.apply(null));
        System.out.println("Validate If String is Null Or Not: " + functionValidatingIfStringIsNullOrNot.apply(""));
        System.out.println("Validate If String is Null Or Not: " + functionValidatingIfStringIsNullOrNot.apply("Hello"));
    }


    public void concatStrings() {

        BiFunction<String, String, String> biFunctionStringConcat = (s1, s2) -> s1 + s2 + s1;

        System.out.println("Concat String: " + biFunctionStringConcat.apply("-", "Canada"));
    }

    public void getIndexOfString() {

        String pattern = "Welcome to the Jungle";
        Function<String, Integer> functionIndexOfString = pattern::indexOf;

        System.out.println("Get Index Of String: " + functionIndexOfString.apply("Welcome"));
        System.out.println("Get Index Of String: " + functionIndexOfString.apply("Jungle"));
    }

    public static void main(String[] args) {
        FunctionExample functionExample = new FunctionExample();
        functionExample.concatStrings();

        functionExample.wrapWithParentheses();

        functionExample.upperCaseConversion();

        functionExample.getStringLength();

        functionExample.getIndexOfString();
    }
}

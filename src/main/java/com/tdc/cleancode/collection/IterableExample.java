package com.tdc.cleancode.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IterableExample {

    public void modifyOneCountry(String country) {

        List<StringBuilder> stringBuilderList = Arrays.asList(
                new StringBuilder("Canada"),
                new StringBuilder("Brazil"),
                new StringBuilder("United States"));

        stringBuilderList.stream()
                .filter(country::contentEquals)
                .forEach(stringBuilder -> stringBuilder.append(" of America"));

        List<String> countryList = stringBuilderList.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());

        System.out.println("Size: " + countryList.size());
        System.out.println("Country List: " + countryList);
    }

    public static void main(String[] args) {
        IterableExample iterableExample = new IterableExample();
        iterableExample.modifyOneCountry("United States");
    }
}

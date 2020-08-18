package com.tdc.cleancode.stream_api.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsExample {

    public void removeFromListIfSomeConditionIsTrue() {

        List<String> list = new ArrayList<>(Arrays.asList(
                "Roan", "Paula", "Otavio", "Rafael", "Bruno", "Carol"));

        list.removeIf(element -> element.length() % 2 == 1);

        System.out.println("List Size: " + list.size());

        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        CollectionsExample collectionsExample = new CollectionsExample();
        collectionsExample.removeFromListIfSomeConditionIsTrue();
    }
}

package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {

    public void clearGivenList() {

        Consumer<List<String>> consumer = List::clear;

        List<String> list = new ArrayList<>(Arrays.asList("Roan", "Paula", "Otavio"));
        consumer.accept(list);
        System.out.println(list);
    }


    public void appendString() {

        Consumer<StringBuilder> consumer = sb -> sb.append(" Brasil");

        StringBuilder sb = new StringBuilder("Roan");
        consumer.accept(sb);
        System.out.println(sb);
    }

    public void appendStringInTheBegin() {

        Consumer<StringBuilder> consumer = sb -> sb.insert(0, "1.");

        StringBuilder sb = new StringBuilder("Roan");
        consumer.accept(sb);
        System.out.println(sb);
    }

    public void appendStringInTheBorders() {

        Consumer<StringBuilder> consumerAppenderInTheBegin = sb -> sb.append('|');
        Consumer<StringBuilder> consumerAppenderInTheEnd = sb -> sb.insert(0, '|');

        Consumer<StringBuilder> consumer = consumerAppenderInTheBegin.andThen(consumerAppenderInTheEnd);

        StringBuilder sb = new StringBuilder("Canada");
        consumer.accept(sb);
        System.out.println(sb);
    }

    public void addAStringInList() {

        List<String> stringList = new ArrayList<>(Arrays.asList("Roan", "Paula", "Otavio"));

        BiConsumer<List<String>, String> biConsumer = List::add;
        biConsumer.accept(stringList, "Rafael");

        System.out.println(stringList);
    }

    public void addKeyValueToMap() {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Paula");
        map.put(2, "Otavio");
        map.put(3, "Rafael");

        BiConsumer<Integer, String> biConsumer = map::put;
        biConsumer.accept(4, "Roan");

        System.out.println(map);
    }

    public static void main(String[] args) {
        ConsumerExample consumerExample = new ConsumerExample();
        consumerExample.clearGivenList();

        consumerExample.appendString();

        consumerExample.appendStringInTheBegin();

        consumerExample.appendStringInTheBorders();

        consumerExample.addAStringInList();

        consumerExample.addKeyValueToMap();
    }
}

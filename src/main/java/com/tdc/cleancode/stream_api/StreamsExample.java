package com.tdc.cleancode.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {

    public void convertAllListToUpperCase() {

        List<String> wordsList = Arrays.asList(
                "doll", "ball", "hat", "screen", "kindle", "book", "test", "car", "camera", "city");

        List<String> result = wordsList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("UpperCase List: " + result);
    }

    public void filterATypeOfWordToUpperCase() {

        List<String> wordsList = Arrays.asList(
                "doll", "ball", "hat", "screen", "kindle", "book", "test", "car", "camera", "city");

        List<String> result = wordsList.stream()
                .filter(s -> s.length() % 2 == 1)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Words Filtered to UpperCase List: " + result);
    }

    public void generateAListWithWordsFrom3To5() {

        List<String> wordsList = Arrays.asList(
                "doll", "ball", "hat", "microphone", "vancouver", "book", "test", "car", "camera", "city");

        List<String> result = wordsList.stream()
                .limit(5)
                .skip(2)
                .collect(Collectors.toList());

        System.out.println("List With Words From 3 To 5: " + result);
    }

    public void generateAListWithFirstNonRepeatedLetters() {

        List<String> wordsList = Arrays.asList(
                "doll", "ball", "hat", "microphone", "vancouver", "book", "test", "car", "camera", "city");

        List<String> result = wordsList.stream()
                .map(s -> s.substring(0, 1))
                .distinct()
                .collect(Collectors.toList());

        System.out.println("List With First Non Repeated Letters: " + result);
    }

    /**
     * Given a list of words, count the number of different lengths of those words.
     * Try not to create any list.
     */

    public void countNumberOfDifferentLenghts() {

        List<String> input = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        long result = input.stream()
                .map(String::length)
                .distinct()
                .count();

        System.out.println("Count number of Different lengths of words: "+ result);
    }

    public void createAList() {

        List<String> result = Stream
                .generate(() -> "Montreal")
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Create a list: " + result);
    }


    public void createCustomizedList() {

        List<String> result = Stream
                .iterate("+", s -> s + "+")
                .limit(7)
                .skip(2)
                .collect(Collectors.toList());

        System.out.println("Create a Customized list: " + result);
    }


    public void createAIntegerList() {

        List<Integer> result = IntStream.range(1, 6).boxed().collect(Collectors.toList());

        System.out.println("Create a Integer List: " + result);
    }

    public void getLettersFromStringOrdered() {

        // This is the Java 8 solution
//        Function<String, List<String>> wordToLetters =
//                word -> word.chars().filter(Character::isLetter).mapToObj(letter -> (char)letter).map(String::valueOf)
//                        .map(String::toLowerCase).distinct().sorted().collect(Collectors.toList());

        // Starting with Java 11 you can write the following
        Function<String, List<String>> wordToLetters =
                word -> word.chars()
                        .filter(Character::isLetter)
                        .mapToObj(Character::toString)
                        .map(String::toLowerCase)
                        .distinct()
                        .sorted()
                        .collect(Collectors.toList());

        System.out.println(wordToLetters.apply("Montreal Quebec"));
    }

    public static void main(String[] args) {
        StreamsExample streamsExample = new StreamsExample();
        streamsExample.convertAllListToUpperCase();

        streamsExample.countNumberOfDifferentLenghts();

        streamsExample.createAIntegerList();

        streamsExample.createAList();

        streamsExample.createCustomizedList();

        streamsExample.filterATypeOfWordToUpperCase();

        streamsExample.generateAListWithFirstNonRepeatedLetters();

        streamsExample.getLettersFromStringOrdered();
    }
}

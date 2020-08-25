package com.tdc.cleancode.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListExample {

  public static final String EMPTY = "";

  public void replaceAllListToUpperCase() {

            List<String> countryList = Arrays.asList(
                    "Canada", "Nova Zelandia", "Australia", "United States", "China", "Brazil");

            countryList.replaceAll(String::toUpperCase);

            System.out.println("UpperCase Country list: " + countryList);
        }

        public void replaceAllNullValuesToEmptyString() {

            List<String> carList = Arrays.asList(
                    "Sportage", null, "Ferrari", "Beetle", null, "Porsche");

            carList.replaceAll(car -> car == null ? EMPTY : car);

            System.out.println("Replace Null Values To Empty Values: " + carList);
        }

        public void orderBy() {

            List<String> provinceList = Arrays.asList(
                    "Quebec", "Ontario", "Vancouver", "Alberta", "Winnipeg");

            provinceList.sort(Comparator.naturalOrder());

            System.out.println("Order in Alphabetical Order: " + provinceList);
        }


        public void orderByStringSize() {

            List<String> nameList = Arrays.asList(
                    "Roan Brasil", "Otavio Santana", "Paula Santana", "Rafael Benevides", "Bruno kaufmann", "Bruno Souza");

            Comparator<String> cmp = Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder());

            nameList.sort(cmp);

            System.out.println("Order String By Size: " + nameList);
        }

    public static void main(String[] args) {
        ListExample listExample = new ListExample();

        listExample.replaceAllListToUpperCase();

        listExample.replaceAllNullValuesToEmptyString();

        listExample.orderBy();

        listExample.orderByStringSize();
    }
}

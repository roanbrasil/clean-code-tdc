package com.tdc.cleancode.lambda_expressions.after;

import com.tdc.cleancode.lambda_expressions.before.ComparationJava7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Comparation {
    public void nameComparation(){
        final List<String> names = Arrays.asList("Roan", "Paula", "Otavio", "Paulo", "Rafael", "Paula");

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                return name1.compareTo(name2);
            }
        });
        System.out.println(names);
    }


    public static void main(String[] args) {
        ComparationJava7 comparationJava7 = new ComparationJava7();
        comparationJava7.nameComparationJava7();
    }
}

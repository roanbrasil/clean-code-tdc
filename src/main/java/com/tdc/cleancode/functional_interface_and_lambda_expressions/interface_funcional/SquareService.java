package com.tdc.cleancode.functional_interface_and_lambda_expressions.interface_funcional;

import java.util.function.Function;

public class SquareService {
    public static void main(String[] args) {
        Integer valueInt = 5;

        //Expressão lambda que calcula o método
        Square<Integer> squareInt = (x) -> x * x;

        Integer calculatedSquare = squareInt.calculate(valueInt);
        System.out.println(calculatedSquare);

        Double valueDouble = 11.1;

        Square<Double> squareDouble = (x) -> x * x;

        Double calculatedSquareDouble = squareDouble.calculate(valueDouble);
        System.out.println(calculatedSquareDouble);
    }
}

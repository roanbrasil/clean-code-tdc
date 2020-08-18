package com.tdc.cleancode.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class SumOperation implements Supplier<Integer> {

    private final int firstNumber;
    private final int secondNumber;

    public SumOperation(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public Integer get() {
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        return firstNumber + secondNumber;
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        SumOperation sumOperation = new SumOperation(5, 24);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(sumOperation);
        future.thenAccept(System.out::println);
        System.out.println("CompletableFuture Example - The End of Execution.... ");
        Thread.sleep(10000);
    }
}

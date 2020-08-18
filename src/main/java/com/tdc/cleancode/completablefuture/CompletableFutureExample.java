package com.tdc.cleancode.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class CompletableFutureExample {

    final Function<Long, Long> factorial = x -> x == 1
            ? x
            : x * this.factorial.apply(x - 1);

    public void executeService(Long number){
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> factorial.apply(number));
        while (!completableFuture.isDone()) {
            System.out.println("CompletableFuture is not finished yet...");
        }
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CompletableFutureExample completableFutureExample = new CompletableFutureExample();
        completableFutureExample.executeService(9L);
    }
}

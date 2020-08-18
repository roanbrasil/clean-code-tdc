package com.tdc.cleancode.completablefuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

public class FutureTaskExample {

    final Function<Long, Long> factorial = x -> x == 1
            ? x
            : x * this.factorial.apply(x - 1);


    public void executeService(Long number) {
        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<Long> futureTask = threadpool.submit(() -> factorial.apply(number));

        while (!futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet...");
        }
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            threadpool.shutdown();
        }
    }

    public static void main(String[] args) {
        FutureTaskExample futureTaskExample = new FutureTaskExample();
        futureTaskExample.executeService(9L);
    }
}

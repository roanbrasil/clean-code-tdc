package com.tdc.cleancode.completablefuture;

import com.tdc.cleancode.dto.Country;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureSimpleExample {

    private Country country;

    public CompletableFutureSimpleExample(Country country){
        this.country = country;
    }

    public void creatingSimpleCompletableFuture(){
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Some Value");
        System.out.println("Is Done? " + completableFuture.isDone());
        try {
            System.out.println("Get Value: " + completableFuture.get());
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("No Exception expected");
        }
    }

    public void process(){
        System.out.println(Thread.currentThread() + " Process");
        country.setName("Canada");
    }

    /**
     * Se tu precisa rodar qualquer coisa em background sem a necessidade de retorno,
     * CompletableFuture.runAsync() é uma ótima pedida, pois ele utiliza um Runnable e retorna
     * CompletableFuture<Void>
     */
    public void completableFutureRunAsyncNoReturn() {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(this::process);
        runAsync.join();
        System.out.println("Country from completableFutureRunAsyncNoReturn: " + country.getName());
    }

    public Country processWithReturn(String countryName){
        country.setName(countryName);
        return country;
    }

    /**
     * Se tu precisa rodar qualquer coisa em background com a necessidade de retorno,
     * CompletableFuture.supplyAsync() é uma ótima pedida, pois ele utiliza um Supplier<T> e retorna
     * te retornará um CompletableFuture<T>
     */
    public void completableFutureRunAsyncWithReturn(String countryName) {
        CompletableFuture<Country> supplyAsync = CompletableFuture.supplyAsync(() -> this.processWithReturn(countryName));
        try {
            System.out.println("Country from Async Supply With Return: " + supplyAsync.get()); //Blocking
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("No Exception expected");
        }
    }

    public void completableFutureWithCustomExecutor(String countryName){
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        CompletableFuture<Country> supplyAsync = CompletableFuture.supplyAsync(() -> this.processWithReturn(countryName), newFixedThreadPool);
        try {
            System.out.println("Country from CustomExecutor: " + supplyAsync.get());
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("No Exception expected");
        }
    }

    public static void main(String[] args) {
       CompletableFutureSimpleExample completableFutureSimpleExample = new CompletableFutureSimpleExample(new Country());

       completableFutureSimpleExample.creatingSimpleCompletableFuture();

       completableFutureSimpleExample.completableFutureRunAsyncNoReturn();

       completableFutureSimpleExample.completableFutureRunAsyncWithReturn("Brazil");

       completableFutureSimpleExample.completableFutureWithCustomExecutor("USA");
    }
}

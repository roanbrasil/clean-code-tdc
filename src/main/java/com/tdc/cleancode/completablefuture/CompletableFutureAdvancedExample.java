package com.tdc.cleancode.completablefuture;

import com.tdc.cleancode.dto.Country;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class CompletableFutureAdvancedExample {

    private Country country;

    public CompletableFutureAdvancedExample(Country country){
        this.country = country;
    }

    public Country process(){
        country.setName("Canada");
        return country;
    }

    private void notifyCountry(Country country) {
        System.out.println(country);
    }

    /**
     * f We want to run some code after receiving some value from Future
     * then we can use thenAccept()
     */
    public void completableFutureThenAccept() {
        CompletableFuture.supplyAsync(this::process)
                .thenAccept(this::notifyCountry) //Non Blocking,notify method will be called automatically after compilation or process method
                .join();
    }

    private String countryRetriever(Country country){
        return country.getName();
    }

    /**
     * If We want to run some code after receiving value from Future
     * and then want to return some value for this we can use thenApply()
     */
    public void completableFutureThenApply() {
        String result = CompletableFuture.supplyAsync(this::process)
                .thenApply(this::countryRetriever)
                .join();
        System.out.println(result);
    }

    private void print(){
        System.out.println("Print inside the Run: " + country);
    }

    /**
     * If We want to run some code after completion of the Future
     * and dont want to return any value for this we can use thenRun()
     */
    public void completableFutureThenRun() {
        CompletableFuture.supplyAsync(this::process)
                .thenRun(this::print)
                .join();
    }

    public static void main(String[] args) {
        CompletableFutureAdvancedExample completableFutureAdvancedExample = new CompletableFutureAdvancedExample(new Country());

        completableFutureAdvancedExample.completableFutureThenAccept();

        completableFutureAdvancedExample.completableFutureThenApply();

        completableFutureAdvancedExample.completableFutureThenRun();

    }

}

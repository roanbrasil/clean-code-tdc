package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class LambdaExpressions {

    public void createThread(){
        new Thread( () -> System.out.println("Thread started!!!")).start();
    }

    @FunctionalInterface
    public interface LambdaInterface {
        String doLambdaThing(String value);
    }

    private String printASentence(String valueToSentence, LambdaInterface lambdaInterface){
        return lambdaInterface.doLambdaThing(valueToSentence);
    }

    public void executePrintASentence(){
        LambdaInterface lambdaInterface = parameter -> String.format(" Hello from Canada %s !!!", parameter);
        System.out.println(this.printASentence("Paula Santana", lambdaInterface));
    }

    public String processSupplier(Supplier<String> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        LambdaExpressions lambdaExpressions = new LambdaExpressions();
        lambdaExpressions.createThread();

        lambdaExpressions.executePrintASentence();

        System.out.println(lambdaExpressions.processSupplier(() -> LocalDateTime.now().toString()));
    }
}

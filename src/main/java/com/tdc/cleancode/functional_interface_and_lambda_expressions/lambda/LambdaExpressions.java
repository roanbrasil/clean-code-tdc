package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda;

public class LambdaExpressions {

    public void createThread(){
        new Thread( () -> System.out.println("Thread started!!!")).start();
    }

    public static void main(String[] args) {
        LambdaExpressions lambdaExpressions = new LambdaExpressions();
        lambdaExpressions.createThread();
    }
}

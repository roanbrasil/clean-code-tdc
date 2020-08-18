package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern;

import java.util.function.Function;

@FunctionalInterface
public interface Executor<T, R> {

    Class<T> type();

    default TypeConverter<T, R> execute(Function<T, R> function){
        return  visitorBuilder -> visitorBuilder.register(type(), function);
    }
}

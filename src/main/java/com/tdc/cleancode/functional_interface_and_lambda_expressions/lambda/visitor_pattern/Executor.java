package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern;

import java.util.function.Function;

@FunctionalInterface
public interface Executor<T> {

    Class<?> type();

    default TypeConverter<T> execute(Function<Object, T> function){
        return  visitorBuilder -> visitorBuilder.register(type(), function);
    }
}

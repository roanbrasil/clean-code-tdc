package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern;

import java.util.function.Function;

public interface ChainExecutor<T, R> {

    Object get(int index);

    default Class<T> type(){
        return (Class<T>)get(1);
    }

    default TypeConverter<T, R> previousConsumer(){
        return (TypeConverter<T, R>) get(0);
    }

    default TypeConverter<T, R> execute(Function<T, R> function){
        return  previousConsumer().andThen(
                visitorBuilder -> visitorBuilder.register(type(), function));
    }
}

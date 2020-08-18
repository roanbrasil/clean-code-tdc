package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern;

import java.util.function.Function;

public interface ChainExecutor<T> {

    Object get(int index);

    default Class<?> type(){
        return (Class<?>)get(1);
    }

    default TypeConverter<T> previousConsumer(){
        return (TypeConverter<T>) get(0);
    }

    default TypeConverter<T> execute(Function<Object, T> function){
        return  previousConsumer().andThen(
                visitorBuilder -> visitorBuilder.register(type(), function));
    }
}

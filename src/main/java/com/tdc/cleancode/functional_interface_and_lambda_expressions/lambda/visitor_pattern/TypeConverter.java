package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern;

import java.util.function.Consumer;

public interface TypeConverter<T, R> extends Consumer<VisitorBuilder<R>> {

    default <T> ChainExecutor<T, R> forType(Class<T> type){
        return index -> index == 0 ? this : type;
    }

    default TypeConverter<T, R> andThen(TypeConverter<T, R> after){
        return t -> { this.accept(t); after.accept(t);};
    }
}

package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern;

import java.util.function.Consumer;

public interface TypeConverter<T> extends Consumer<VisitorBuilder<T>> {

    default ChainExecutor<T> forType(Class<?> type){
        return index -> index == 0 ? this : type;
    }

    default TypeConverter<T> andThen(TypeConverter<T> after){
        return t -> { this.accept(t); after.accept(t);};
    }
}

package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern;

import java.util.function.Function;

@FunctionalInterface
public interface VisitorBuilder<T> {

    void register(Class<?> type, Function<Object, T> function);
}

package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern;

import java.util.function.Function;

@FunctionalInterface
public interface VisitorBuilder<R> {

   <T> void register(Class<T> type, Function<T, R> function);
}

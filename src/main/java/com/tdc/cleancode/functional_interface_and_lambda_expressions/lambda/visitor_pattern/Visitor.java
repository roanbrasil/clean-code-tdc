package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface Visitor<T> {

    T visit(Object o);

    static <T> Executor<T> forType(Class<?> type) {
        return () -> type;
    }

    static <T> Visitor<T> of(Consumer<VisitorBuilder<T>> consumer){
        Map<Class<?>, Function<Object, T>> registry = new HashMap<>();
        consumer.accept((type, function) -> registry.put(type, function));
        System.out.println("Register: " + registry.keySet());
        return o -> registry.get(o.getClass()).apply(o);
    }
}

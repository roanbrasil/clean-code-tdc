package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface Visitor<R> {

    R visit(Object o);

    static <T, R> Executor<T, R> forType(Class<T> type) {
        return () -> type;
    }

    static <R> Visitor<R> of(Consumer<VisitorBuilder<R>> consumer){
        Map<Class<?>, Function<Object, R>> registry = new HashMap<>();
        VisitorBuilder<R> visitorBuilder = new VisitorBuilder<R>() {
            @Override
            public <T> void register(Class<T> type, Function<T, R> function) {
               registry.put(type, function.compose(type::cast));
            }
        };
        consumer.accept(visitorBuilder);
        System.out.println("Register: " + registry.keySet());
        return o -> registry.get(o.getClass()).apply(o);
    }
}

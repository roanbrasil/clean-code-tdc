package com.tdc.cleancode.functional_interface_and_lambda_expressions.interface_funcional;

@FunctionalInterface
public interface Square<T> {

    T calculate(T value);
}

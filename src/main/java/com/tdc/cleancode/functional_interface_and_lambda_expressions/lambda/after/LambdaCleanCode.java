package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.after;

import com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.dto.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaCleanCode {

    public List<Person> peopleOlderThan18(List<Person> persons){

        final Predicate<Person> isMaleOrAdult = p -> p.isAdult(LocalDate.now());

        return persons.stream()
                .filter(isMaleOrAdult)
                .collect(Collectors.toList());
    }
}

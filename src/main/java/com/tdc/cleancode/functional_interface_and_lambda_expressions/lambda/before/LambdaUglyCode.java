package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.before;

import com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.dto.Gender;
import com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.dto.Person;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaUglyCode {

    public List<Person> peopleOlderThan18(List<Person> persons){
         return persons.stream().filter(p -> {
            LocalDate now = LocalDate.now();
            Duration age = Duration.between(p.getBirthDate(), now);
            Duration adult = Duration.of(18, ChronoUnit.YEARS);
             return age.compareTo(adult) > 0;
         }).collect(Collectors.toList());
    }
}

package com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern;

import com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern.model.Body;
import com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern.model.Car;
import com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern.model.Engine;
import com.tdc.cleancode.functional_interface_and_lambda_expressions.lambda.visitor_pattern.model.Wheel;

import java.util.function.Consumer;

public class VisitorExample {
    public static void main(String[] args) {

        Car car = new Car();
        Engine engine = new Engine();
        Body body = new Body();
        Wheel wheel = new Wheel();

        Consumer<VisitorBuilder<String>> consumer =
                Visitor.<Car, String>forType(Car.class).execute(c ->  "Visiting car: " + c)
                        .forType(Engine.class).execute(e ->  "Visiting engine: " + e)
                        .forType(Body.class).execute(b -> "Visiting body: " + b)
                        .forType(Wheel.class).execute(w -> "Visiting wheel: " + w);

        Visitor<String> visitor = Visitor.of(consumer);

        String visitedEngine = visitor.visit(engine);
        System.out.println(visitedEngine);

        String visitedCar = visitor.visit(car);
        System.out.println(visitedCar);

        String visitedBody = visitor.visit(body);
        System.out.println(visitedBody);

        String visitedWheel = visitor.visit(wheel);
        System.out.println(visitedWheel);
    }
}

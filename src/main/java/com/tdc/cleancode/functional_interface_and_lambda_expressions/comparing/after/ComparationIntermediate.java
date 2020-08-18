package com.tdc.cleancode.functional_interface_and_lambda_expressions.comparing.after;

import com.tdc.cleancode.dto.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparationIntermediate {
    public void nameComparation(){
         List<Employee> employees = new ArrayList<>();

        this.setEmployees(employees);

        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));
        System.out.println(employees.toString());
    }


    private void setEmployees(List<Employee> employees){

        Employee employee1 = new Employee();
        employee1.setName("Paula Santana");
        employee1.setAge("30");
        employee1.setSalary(BigDecimal.valueOf(100.00));
        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.setName("Rafael Benevides");
        employee2.setAge("43");
        employee2.setSalary(BigDecimal.valueOf(100000.00));
        employees.add(employee2);

        Employee employee3 = new Employee();
        employee3.setName("Roan Brasil");
        employee3.setAge("35");
        employee3.setSalary(BigDecimal.valueOf(1.00));
        employees.add(employee3);

        Employee employee4 = new Employee();
        employee4.setName("Otavio Santana");
        employee4.setAge("32");
        employee4.setSalary(BigDecimal.valueOf(50000.00));
        employees.add(employee4);
    }

    public static void main(String[] args) {
        Comparation comparation = new Comparation();
        comparation.nameComparation();
    }
}

package com.tdc.cleancode.lambda_expressions.comparing.after;

import com.tdc.cleancode.dto.Employee;

import java.util.*;


public class Comparation {
    public void nameComparation(){
        List<Employee> employees = new ArrayList<>();

        this.setEmployees(employees);

        //method reference
        Collections.sort(employees, Comparator.comparing(Employee::getName));

        System.out.println(employees.toString());
    }


    private void setEmployees(List<Employee> employees){

        Employee employee1 = new Employee();
        employee1.setName("Paula Santana");
        employee1.setAge("30");
        employee1.setSalary("100.00");
        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.setName("Rafael Benevides");
        employee2.setAge("43");
        employee2.setSalary("100000.00");
        employees.add(employee2);

        Employee employee3 = new Employee();
        employee3.setName("Roan Brasil");
        employee3.setAge("35");
        employee3.setSalary("1.00");
        employees.add(employee3);

        Employee employee4 = new Employee();
        employee4.setName("Otavio Santana");
        employee4.setAge("32");
        employee4.setSalary("50000.00");
        employees.add(employee4);
    }

    public static void main(String[] args) {
        Comparation comparation = new Comparation();
        comparation.nameComparation();
    }
}

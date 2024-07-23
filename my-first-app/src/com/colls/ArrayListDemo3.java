package com.colls;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListDemo3 {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(23, "John", 34344.34));
        employees.add(new Employee(24, "Alice", 56566.5));
        employees.add(new Employee(25, "Bob", 78788.78));
        employees.add(2, new Employee(26, "Charlie", 90909.9));
        System.out.println(employees);

        System.out.println(new Employee(23, "John", 34344.34).equals(new Employee(23, "John", 34344.34)));


        System.out.println(employees.contains(new Employee(23, "John", 34344.34)));
    }
}

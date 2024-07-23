package com.colls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UtilitiesDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(23, "John", 34344.34));
        employees.add(new Employee(14, "Alice", 56566.5));
        employees.add(new Employee(5, "Bob", 78788.78));
        employees.add(new Employee(26, "Charlie", 90909.9));
        employees.add(new Employee(26, "Arlie", 90909.9));



        System.out.println(employees);

        employees.stream()
        .filter(e -> e.name.startsWith("A"))
        .forEach(System.out::println);

        // natural criteria sort 
        // Collections.sort(employees);

        // other criteria sort 
        //overloaded sort method with custom comparator .. comparator takes precedence over compareTo method
        Collections.sort(employees, new SalaryComparator());
        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e1.getName()));

        Employee maxEmployee =  Collections.max(employees, new SalaryComparator());
        System.out.println("Max Id Employee: " + maxEmployee);

        // Collections.sort(employees, new Comparator<Employee>() {
            
        // });

        System.out.println("After sorting: " + employees);
    }
}

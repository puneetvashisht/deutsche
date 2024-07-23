package com.colls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetsDemo2 {
    public static void main(String[] args) {
        
        // List<String> fruits = new ArrayList<>();

        // Set<String> list = new HashSet<>();
        // boolean first = list.add("apple");
        // boolean second = list.add("apple");

        // System.out.println(first);
        // System.out.println(second);
        // System.out.println(list);



         Set<Employee> employees = new TreeSet<>();
        employees.add(new Employee(23, "John", 34344.34));
        employees.add(new Employee(14, "Alice", 56566.5));
        employees.add(new Employee(5, "Bob", 78788.78));
        employees.add(new Employee(26, "Charlie", 90909.9));
        employees.add(new Employee(26, "Charlie", 90909.9));
        System.out.println(employees);


        Set<String> fruits = new TreeSet<>();
        fruits.add("orange");
        fruits.add("pineapple");
        fruits.add("apple");
        fruits.add("banana");
        fruits.add(("apple"));

        System.out.println(fruits);



        System.out.println(employees.contains(new Employee(25, "Bob", 78788.78)));


    //     Set<String> list2 = new TreeSet<>();
    //     list2.add("pineapple");
    //     list2.add("grapes");
    //     list2.add("apple");
    //     System.out.println(list2);

    //     Set<Employee> employees = new LinkedHashSet<>();
    //     Employee e1 = new Employee(23, "abc");
    //     employees.add(e1);
    //     Employee e2 = new Employee(3, "axy");
    //     employees.add(e2);
    //     Employee e21 = new Employee(3, "axy");
    //     employees.add(e21);
    //    Employee e3 = new Employee(24, "abcd");
    //    employees.add(e3);
    //    System.out.println(employees);
        
    //    System.out.println(employees.contains(new Employee(344, "dd")));



    }
}

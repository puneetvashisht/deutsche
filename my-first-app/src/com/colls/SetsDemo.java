package com.colls;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class SetsDemo {
    public static void main(String[] args) {
        
        Set<String> list = new HashSet<>();
        list.add("apple");
        list.add("apple");
        System.out.println(list);

        Set<String> list2 = new TreeSet<>();
        list2.add("pineapple");
        list2.add("grapes");
        list2.add("apple");
        System.out.println(list2);

        Set<Employee> employees = new LinkedHashSet<>();
        Employee e1 = new Employee(23, "abc");
        employees.add(e1);
        Employee e2 = new Employee(3, "axy");
        employees.add(e2);
        Employee e21 = new Employee(3, "axy");
        employees.add(e21);
       Employee e3 = new Employee(24, "abcd");
       employees.add(e3);
       System.out.println(employees);
        
       System.out.println(employees.contains(new Employee(344, "dd")));

        
       // Using Iterator for the set of employees
       Iterator<Employee> iterator = employees.iterator();
       while (iterator.hasNext()) {
           Employee employee = iterator.next();
           System.out.println(employee);
       }

        // Bulk operations
        Set<Employee> newEmployees = new HashSet<>();
        employees.add(new Employee(23, "John", 34344.34));
        employees.add(new Employee(14, "Alice", 56566.5));
        employees.add(new Employee(5, "Bob", 78788.78));
        employees.add(new Employee(26, "Charlie", 90909.9));
        employees.add(new Employee(26, "Charlie", 90909.9));

        employees.addAll(newEmployees);
        System.out.println("After addAll: " + employees);

        employees.removeAll(newEmployees);
        System.out.println("After removeAll: " + employees);

        employees.retainAll(newEmployees);
        System.out.println("After retainAll: " + employees);

        employees.clear();
        System.out.println("After clear: " + employees);

        employees.add(e1);
        employees.add(e2);
        Object[] employeesArray = employees.toArray();
        System.out.println("Array: ");
        for (Object employee : employeesArray) {
            System.out.println(employee);
        }

        Employee[] employeesTypedArray = employees.toArray(new Employee[0]);
        System.out.println("Typed Array: ");
        for (Employee employee : employeesTypedArray) {
            System.out.println(employee);
        }

    }
}

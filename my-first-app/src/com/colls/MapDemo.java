package com.colls;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        
        Map<Integer, Employee> employeeMap = new TreeMap<>();

        Employee e1 = new Employee(23, "abc", 34343.34);
        employeeMap.put(23, e1);
     //    employeeMap.put()
         Employee e2 = new Employee(3, "axy", 454544.45);
         employeeMap.put(31, e2);
         Employee e21 = new Employee(3, "axy", 676767);
         employeeMap.put(3, e21);
        Employee e3 = new Employee(24, "abcd", 565656.56);
        employeeMap.put(24, e3);



        // Using Iterator for the entry set
        Iterator<Map.Entry<Integer, Employee>> iterator = employeeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Employee> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

       

        // Bulk operations on keys
        Set<Integer> keys = employeeMap.keySet();
        Collection<Integer> keysToCheck = new HashSet<>();
        keysToCheck.add(23);
        keysToCheck.add(24);
        System.out.println("Keys contain all 23 and 24: " + keys.containsAll(keysToCheck));

        // Bulk operations on values
        Collection<Employee> values = employeeMap.values();
        Collection<Employee> employeesToCheck = new HashSet<>();
        employeesToCheck.add(e1);
        employeesToCheck.add(e3);
        System.out.println("Values contain all e1 and e3: " + values.containsAll(employeesToCheck));

        employeeMap.clear();
        System.out.println("Map after clear: " + employeeMap);


        for(Integer key: keys){
            System.out.println(employeeMap.get(key));
           }
    
           System.out.println(employeeMap.get(24));
    
    }
}

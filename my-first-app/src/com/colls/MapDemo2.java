package com.colls;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo2 {
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

       System.out.println(employeeMap.get(23));
       System.out.println(employeeMap);


       Set<Integer> keys = employeeMap.keySet();
       System.out.println(keys);

       Set<Entry<Integer, Employee>> entries = employeeMap.entrySet();
       for(Entry<Integer, Employee> entry: entries){
        System.out.println(entry.getKey() + " -> " + entry.getValue());
       }
       

       for(Integer key: keys){
        System.out.println(employeeMap.get(key));
       }


       Collection<Employee> employeeList = employeeMap.values();
       System.out.println(employeeList);

    //    for(Integer key: keys){
    //     System.out.println(employeeMap.get(key));
    //    }

    //    System.out.println(employeeMap.get(24));
    }
}

package com.tkhts.junit;

public class Employee {
    int id;
    String name;
    double salary;

   

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }



    public double incrementSalary(){
        return this.salary *= 1.1;
    }
}

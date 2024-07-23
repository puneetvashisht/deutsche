package com.colls;

public class Employee extends Object{
    int id;
    String name;
    static String COMPANY_NAME = "L&T Mindtree";

    public static String getCOMPANY_NAME() {
        // System.out.println(name);
        return COMPANY_NAME;
    }
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
    
}

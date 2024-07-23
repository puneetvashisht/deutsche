package com.colls;

public class Employee extends Object implements Comparable<Employee> {
    int id;
    String name;
    double salary;
    static String COMPANY_NAME = "L&T Mindtree";



    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public static void setCOMPANY_NAME(String cOMPANY_NAME) {
        COMPANY_NAME = cOMPANY_NAME;
    }
    public static String getCOMPANY_NAME() {
        // System.out.println(name);
        return COMPANY_NAME;
    }
    public Employee(int id, String name , double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
   // toString method to display employee details
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
    
    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + id;
    //     return result;
    // }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public int compareTo(Employee o) {
       return this.id - o.id;
    }
   
    
}

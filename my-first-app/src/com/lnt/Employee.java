package com.lnt;

import java.util.function.Predicate;

public abstract class Employee extends Object implements Perks   {
    
    // Fields/Properties/State
    int id;
    String name;
   
    public Employee(){
        
    }
    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    abstract void incrementSalary();

    public void applyForLeave(){
        System.out.println("Leave application pending..");
    }



    // @Override
    // public String toString() {
    //     return "Employee [id=" + id + ", name=" + name + "]";
    // }

    @Override
    public void medicalAssurance() {
       System.out.println("Medi Assist Cover 5 lacs");
    }
   

   
}

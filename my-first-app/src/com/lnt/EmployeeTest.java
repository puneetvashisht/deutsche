package com.lnt;

public class EmployeeTest {
    public static void main(String[] args) {
        // Employee emp1 = new Employee(23, "Ravi");

        Employee contractualEmployee = new ContractualEmployee(3, "Priya");
        Employee regularEmployee = new RegularEmployee(2, "Sonia", 10000);
        // Employee emp = new Employee() ;

       Employee employees[] = { contractualEmployee, regularEmployee};

       for(Employee e: employees){
        // e.incrementSalary();
        // e.applyForLeave();
        // e.foodCoupon();
        System.out.println(e.toString());
       }

       System.out.println(contractualEmployee.toString());

    //    for(Employee e : employees){
    //     e.incrementSalary();
    //     e.applyForLeave();
    //     System.out.println(e);
    //    }

    }
}

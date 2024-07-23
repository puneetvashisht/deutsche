package com.threads;

public class IncrementSalary implements Runnable {

    Employee employee;

    public IncrementSalary(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void run() {
      // code execute by threads
      try {
        System.out.println("Executing incrementSalary in thread: " + Thread.currentThread().getName() + " for employee: ");
        employee.incrementSalary();
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
      System.out.println(employee);

    }
    
}

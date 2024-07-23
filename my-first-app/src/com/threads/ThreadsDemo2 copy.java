package com.threads;

public class ThreadsDemo2 {

    public static void main(String[] args) throws InterruptedException {
        
        Employee e1 = new Employee(1, "John", 50000);
        Employee e2 = new Employee(2, "Jane", 60000);
        Employee e3 = new Employee(3, "Tom", 70000);
        Employee e4 = new Employee(4, "John", 50000);

        Employee employees[] = {e1, e2, e3, e4};

        long start = System.currentTimeMillis();
        for(Employee emp : employees) {
            emp.incrementSalary();
            System.out.println(emp);
        }
        long end = System.currentTimeMillis();
        System.out.println("Total time taken: " + (end - start) + " milliseconds");
    }
    
}

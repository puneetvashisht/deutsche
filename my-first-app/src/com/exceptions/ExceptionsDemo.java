package com.exceptions;


public class ExceptionsDemo {

    public static void m2(int x) {
        int y = 1/x;
        if(x<1){
            throw new RuntimeException("x should not be less than 1!");
        }
        // if(x == 100){
        //     throw new RuntimeException("x should not be 100!");
        // }
        System.out.println("m2 invoked..");
    }

    public static void m1(){
        // try{
            m2(0);
        // }
        // catch(Exception e){
        //     System.out.println("Exception occurred: " + e.getMessage());
        //     m2(1);
        // }
           
            System.out.println("This will print");
    }


    public static void main(String[] args) {
        m1();
        System.out.println("all is well...");
    }
    
}

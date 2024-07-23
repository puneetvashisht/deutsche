package com.threads;

class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Being run by "+ Thread.currentThread().getName());
        }
    }

public class ThreadsDemo {

    public static void main(String[] args) {

        // create an object of Thread class and pass an instance of Runnable interface to its constructor
        // call the start method to start the thread

        Runnable r = () -> System.out.println("Being run by "+ Thread.currentThread().getName());

        for(int i=0; i<5; i++){
            // Thread t1 = new Thread( new MyRunnable());
            Thread t1 = new Thread( () -> System.out.println("Being run by "+ Thread.currentThread().getName()));
            t1.start();
        }
  
        System.out.println("Main method being run by "+ Thread.currentThread().getName());

    }
    
}

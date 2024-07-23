package com.colls;

import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("apple");
        list.add(4);
        list.add(true);


        System.out.println(list);

        for(Object obj : list) {
            String string = (String) obj;
            System.out.println(string.charAt(0));
        }

        // access and for loop
        
    }
    
}

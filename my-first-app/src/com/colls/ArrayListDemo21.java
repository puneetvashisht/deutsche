package com.colls;

import java.util.ArrayList;

class Fruit extends Object{
    String name;
    String color;
    public Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }
    @Override
    public String toString() {
        return "Fruit [name=" + name + ", color=" + color + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Fruit other = (Fruit) obj;
        return this.name.equals(other.name) && this.color.equals(other.color);
    }
    
}

public class ArrayListDemo21 {
    public static void main(String[] args) {

        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Fruit("apple", "green"));
        list.add(new Fruit("banana", "yellow"));
        list.add(new Fruit("grape", "purple"));
        list.add(new Fruit("orange", "orange"));
        list.add(new Fruit("apple", "red"));

        System.out.println(list);

        System.out.println(new Fruit("apple", "red").equals(new Fruit("apple", "red")));

        boolean result = list.contains(new Fruit("apple", "red"));
        System.out.println("Fruit is in the list: " + result);

        // ArrayList<String> list = new ArrayList<>();
        // list.add("apple");
        // list.add("grape");
        // list.add("banana");
        // list.add(1, "orange");
        // // list.add(34);

        // for(String string : list) {
        //     System.out.println(string);
        // }

        // System.out.println(list.get(10));

        // boolean result = list.contains("pineapple");
        // System.out.println("apple is in the list: " + result);

        // System.out.println(list);
        // System.out.println(list.contains("apple"));

        // ArrayList<Fruit> list = new ArrayList<>();
        // list.add(new Fruit("apple", "red"));
        // list.add(new Fruit("grapes", "green"));
        // list.add(new Fruit("oranges", "orange"));

        // Fruit searchFruit = new Fruit("apple", "red");
        // System.out.println(list.contains("apple"));

        // System.out.println(new Fruit("apple", "red").equals(new Fruit("apple", "green")));

    }
}

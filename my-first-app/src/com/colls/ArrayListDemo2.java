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
    
}

public class ArrayListDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("grape");
        list.add("banana");

        System.out.println(list);
        System.out.println(list.contains("apple"));

        // ArrayList<Fruit> list = new ArrayList<>();
        // list.add(new Fruit("apple", "red"));
        // list.add(new Fruit("grapes", "green"));
        // list.add(new Fruit("oranges", "orange"));

        // Fruit searchFruit = new Fruit("apple", "red");
        // System.out.println(list.contains("apple"));

        // System.out.println(new Fruit("apple", "red").equals(new Fruit("apple", "green")));

    }
}

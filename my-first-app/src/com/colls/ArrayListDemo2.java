package com.colls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

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
       Fruit f = (Fruit) obj;
       return this.name.equals(f.name);
    }
    
}

public class ArrayListDemo2 {
    public static void main(String[] args) {
        // ArrayList<String> list = new ArrayList<>();
        // list.add("apple");
        // list.add("grape");
        // list.add("banana");

        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Fruit("apple", "red"));
        list.add(new Fruit("grapes", "green"));
        list.add(new Fruit("oranges", "orange"));


        // Using Iterator
        Iterator<Fruit> iterator = list.iterator();
        System.out.println("Using Iterator:");
        while (iterator.hasNext()) {
            Fruit fruit = iterator.next();
            System.out.println(fruit);
        }

        // Using ListIterator
        ListIterator<Fruit> listIterator = list.listIterator();
        System.out.println("Using ListIterator (forward):");
        while (listIterator.hasNext()) {
            Fruit fruit = listIterator.next();
            // listIterator.pre
            System.out.println(fruit);
        }

        System.out.println("Using ListIterator (backward):");
        while (listIterator.hasPrevious()) {
            Fruit fruit = listIterator.previous();
            System.out.println(fruit);
        }

        System.out.println(list);
        // for(String str : list){
        //     System.out.println(str.charAt(0));
        // }
        Fruit searchFruit = new Fruit("apple", "red");
        System.out.println(list.contains(searchFruit));

        // for(int i=0; i<list.size(); i++){
        //     System.out.println(list.get(0));
        // }


         // Bulk operations
        Collection<Fruit> newFruits = new ArrayList<>();
        newFruits.add(new Fruit("banana", "yellow"));
        newFruits.add(new Fruit("kiwi", "brown"));

        list.addAll(newFruits);
        System.out.println("After addAll: " + list);

        list.removeAll(newFruits);
        System.out.println("After removeAll: " + list);

        list.retainAll(newFruits);
        System.out.println("After retainAll: " + list);

        list.clear();
        System.out.println("After clear: " + list);

        list.add(new Fruit("mango", "yellow"));
        list.add(new Fruit("pear", "green"));
        Object[] fruitsArray = list.toArray();
        System.out.println("Array: ");
        for (Object fruit : fruitsArray) {
            System.out.println(fruit);
        }

        Fruit[] fruitsTypedArray = list.toArray(new Fruit[0]);
        System.out.println("Typed Array: ");
        for (Fruit fruit : fruitsTypedArray) {
            System.out.println(fruit);
        }


        System.out.println(new Fruit("apple", "red").equals(new Fruit("apple", "green")));

    }
}

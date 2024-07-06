package org.example;

import org.example.entities.Product;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Product> set = new TreeSet<>(); //Quando o TreeSet é usado para ordenar uma coleção de objetos, este objeto deve implementar o comparable

        set.add(new Product("TV", 900.00));
        set.add(new Product("Notebook", 1200.00));
        set.add(new Product("Tablet", 400.00));

        for (Product p : set) {
            System.out.println(p);
        }
    }
}
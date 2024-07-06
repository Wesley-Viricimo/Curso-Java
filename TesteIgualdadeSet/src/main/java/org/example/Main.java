package org.example;

import org.example.entities.Product;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> set = new HashSet<>();

        set.add(new Product("TV", 900.00));
        set.add(new Product("Notebook", 1200.00));
        set.add(new Product("Tablet", 400.00));

        Product prod = new Product("Notebook", 1200.00);

        //Se a comparação for feita sem equals e hashcode na classe product, o programa irá comparar a instância do objeto, e como são duas instâncias diferentes irá retornar false, porém ao adicionar equals e hashcode, será realizada a comparação por conteúdo
        System.out.println(set.contains(prod));
    }
}
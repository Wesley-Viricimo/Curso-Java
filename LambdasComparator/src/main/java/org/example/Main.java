package org.example;

import org.example.entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.0));
        list.add(new Product("Notebook", 1200.0));
        list.add(new Product("Tablet", 450.0));

        //EXPRESSÃO LAMBDA, OU FUNÇÃO ANÔNIMA OU ARROW FUNCTION PRECISA SER PASSADO DENTRO DOS PARENTESES OS PARAMETROS E DEPOIS DA ARROW, O RETORNO QUE A FUNÇÃO ESPERA OBTER
        Comparator<Product> comp = (Product p1, Product p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

        //list.sort(new MyComparator()); //ORDENANDO UTILIZANDO OBJETO COMPARATOR
        list.sort(comp); //ORDENANDO UTILIZANDO CLASSE ANÔNIMA

        for (Product p : list) {
            System.out.println(p);
        }
    }
}
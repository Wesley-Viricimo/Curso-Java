package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import org.example.entities.Product;
import org.example.services.ProductService;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 350.0));
        list.add(new Product("HD Case", 80.90));

        ProductService ps = new ProductService();

        Predicate<Product> criteria = product -> product.getName().charAt(0) == 'T'; //CRIANDO UM PREDICADO QUE IDENTIFICARÁ SE A DESCRIÇÃO DO PRODUTO COMEÇA COM T

        double sum = ps.filteredSum(list, criteria); //PASSANDO A LISTA DE PRODUTOS E O PREDICADO COMO ARGUMENTO

        System.out.println("Sum = " + String.format("%.2f", sum));
    }
}
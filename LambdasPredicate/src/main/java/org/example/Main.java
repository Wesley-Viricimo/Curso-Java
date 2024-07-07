package org.example;

import org.example.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 350.0));
        list.add(new Product("HD Case", 80.90));

        //list.removeIf(product -> product.getPrice() >= 100.0); //FUNÇÃO REMOVE IF ESPERA UM PREDICADO, NESTE CASO ESTÁ SENDO PASSADO COMO ARGUMENTO UMA EXPRESSÃO LAMBDA, ONDE SERÃO REMOVIDOS OS PRODUTOS COM PREÇO MAIOR OU IGUAL A 100
        //list.removeIf(new ProductPredicate()); //PASSANDO COMO ARGUMENTO A INSTÂNCIA DO PREDICADO
        //list.removeIf(Product::staticProductPredicate); //METHOD REFERENCE, TAMBEM É ACEITO NO SISTEMA LAMBDA DO JAVA, NESTE TIPO DE LAMBDA É INFORMADA A CLASSE ONDE O MÉTODO ESTÁ :: NOME DO MÉTODO

        Predicate<Product> pred = product -> product.getPrice() >= 100.0;
        list.removeIf(pred);

        for (Product p : list) {
            System.out.println(p);
        }
    }
}
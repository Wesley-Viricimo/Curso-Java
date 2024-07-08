package org.example;

import org.example.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 350.0));
        list.add(new Product("HD Case", 80.90));

        Consumer<Product> consumer = product -> product.setPrice(product.getPrice() * 1.1);

        //list.forEach(consumer); //FUNÇÃO FOREACH ESPERA UM CONSUMER COMO PARÂMETRO E PASSA POR TODA A LISTA EXECUTANDO O CONSUMER PASSADO COMO ARGUMENTO
        list.forEach(Product::staticPriceUpdate); //METHOD REFERENCE DO MÉTODO STATICPRICEUPDATE DA CLASSE PRODUCT


        list.forEach(System.out::println); //MÉTHOD REFERENCE PARA MÉTODO PRINTLN
    }
}
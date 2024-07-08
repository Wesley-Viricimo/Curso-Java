package org.example;

import org.example.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 350.0));
        list.add(new Product("HD Case", 80.90));

        Function<Product, String> function = product -> product.getName().toUpperCase();

        //List<String> names = list.stream().map(function).collect(Collectors.toList()); //FUNÇÃO MAP APLICA UMA FUNÇÃO A CADA ELEMENTO DA STREAM, E GERA UMA NOVA STREAM COM OS ELEMENTOS TRANSFORMADOS, DEPOIS ESSES DADOS TRANSFORMADOS SÃO COLETADOS E CONVERTIDOS PARA STRING
        List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList()); //FUNÇÃO MAP APLICA UMA FUNÇÃO A CADA ELEMENTO DA STREAM, E GERA UMA NOVA STREAM COM OS ELEMENTOS TRANSFORMADOS, DEPOIS ESSES DADOS TRANSFORMADOS SÃO COLETADOS E CONVERTIDOS PARA STRING

        names.forEach(System.out::println);
    }
}
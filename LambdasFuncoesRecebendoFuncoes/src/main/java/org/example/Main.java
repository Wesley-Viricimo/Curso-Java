package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

        double sum = ps.filteredSum(list);

        System.out.println("Sum = " + String.format("%.2f", sum));
    }
}
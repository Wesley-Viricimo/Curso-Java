package org.example;

import org.example.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o local do arquivo: ");
        String path = sc.next();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Product> list = new ArrayList<>();

            String line = br.readLine();

            while(line != null) {
                String [] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            double avg = list.stream()
                    .map(product -> product.getPrice()) //GERO UM NOVO STREAM SOMENTE COM OS PREÇOS DOS PRODUTOS
                    .reduce(0.0, (x,y) -> x + y) / list.size();

            System.out.println("Average price: " + String.format("%.2f", avg));

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> names = list.stream()
                    .filter(product -> product.getPrice() < avg)    //FILTRO OS PRODUTOS QUE POSSUAM O PREÇO MENOR QUE A MÉDIA CALCULADA
                    .map(product -> product.getName())              //FUNÇÃO MAP PARA RETORNAR SOMENTE OS NOMES DESSES PRODUTOS QUE POSSUEM O PREÇO ABAIXO DA MÉDIA
                    .sorted(comp.reversed())                        //ORDENA EM ORDEM DECRESCENTE
                    .toList();

            names.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
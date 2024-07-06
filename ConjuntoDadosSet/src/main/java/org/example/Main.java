package org.example;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(); //Conjunto de dados que é mais rápido, porém sem ordenação
        //Set<String> set = new TreeSet<>(); //Conjunto de dados que é mais lento, porém ordenado (Como é um conjunto de strings, seria ordenado por ordem alfabética)
        //Set<String> set = new LinkedHashSet<>(); //Conjunto de dados que é mais lento, porém ordenado (Neste caso é armazenado por ordem de adição)

        set.add("TV");
        set.add("Notebook");
        set.add("Tablet");

        System.out.println(set.contains("Notebook"));

        for (String p: set) {
            System.out.println(p);
        }
    }
}
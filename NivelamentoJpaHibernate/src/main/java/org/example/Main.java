package org.example;

import org.example.domain.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(1, "Carlos da silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(1, "Wesley da silva", "wesley@gmail.com");
        Pessoa p3 = new Pessoa(1, "Sheila da silva", "sheila@gmail.com");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
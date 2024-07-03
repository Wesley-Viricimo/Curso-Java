package org.example;

import org.example.service.PrintService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PrintService<Integer> ps = new PrintService<>();

        System.out.println("Quantos valores deseja digitar: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int valor = sc.nextInt();
            ps.addValue(valor);
        }

        ps.print();
        System.out.println("Primeiro: " + ps.primeiro());

        sc.close();
    }
}
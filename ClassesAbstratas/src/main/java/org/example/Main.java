package org.example;

import org.example.entities.Conta;
import org.example.entities.ContaComercial;
import org.example.entities.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Conta> contas = new ArrayList<>();

        contas.add(new ContaPoupanca(1001, "Alex", 500, 0.01));
        contas.add(new ContaComercial(1001, "Maria", 1000.0, 400.0));
        contas.add(new ContaComercial(1004, "Bob", 300, 0.01));
        contas.add(new ContaComercial(1005, "Anna", 500, 500));

        double soma = 0.0;

        for (Conta conta : contas) {
            soma += conta.getSaldo();
        }

        System.out.printf("Total saldo: %.2f%n", soma);
    }
}
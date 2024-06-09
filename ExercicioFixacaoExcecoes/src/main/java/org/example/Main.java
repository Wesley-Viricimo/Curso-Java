package org.example;

import org.example.entities.Conta;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        try {
            System.out.println("Informe os dados da conta: ");

            System.out.print("Numero: ");
            int numero = sc.nextInt();

            System.out.print("Nome: ");
            String nome = sc.next();

            System.out.print("Saldo inicial: ");
            double saldo = sc.nextDouble();

            System.out.print("Valor de saque permitido: ");
            double valorSaquePermitido = sc.nextDouble();

            Conta conta = new Conta(numero, nome, saldo, valorSaquePermitido);

            System.out.print("Informe um valor para saque: ");
            double valorSaque = sc.nextDouble();

            conta.saque(valorSaque);

            System.out.println();
            System.out.println("Novo saldo: " + conta.getSaldo());

        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
}
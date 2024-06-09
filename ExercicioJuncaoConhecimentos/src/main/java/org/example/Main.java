package org.example;

import org.example.entities.Conta;
import org.example.entities.ContaCorrente;
import org.example.entities.ContaPoupanca;
import org.example.entities.enums.TipoConta;
import org.example.entities.enums.TipoPessoa;
import org.example.exceptions.DomainException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Conta> listContas = new ArrayList<>();

        System.out.print("Informe a quantidade de contas que deseja criar: ");
        int quantidade = sc.nextInt();

        for (int i = 1; i <= quantidade; i++) {
            System.out.println();

            System.out.println("Informe os dados da " + i + "° conta: ");

            System.out.print("Numero: ");
            int numero = sc.nextInt();

            System.out.print("Informe o titular da conta: ");
            String nome = sc.next();

            System.out.print("Informe se é uma conta para pessoa Física ou Jurídica (f/j): ");
            char tipoPessoa = sc.next().charAt(0);

            System.out.print("Informe se o tipo de conta é Corrente ou Poupança (c/p): ");
            char tipoConta = sc.next().charAt(0);

            System.out.print("Informe o saldo inicial da conta: ");
            double saldo = sc.nextDouble();

            System.out.print("Informe o limite de saque da conta: ");
            double limiteSaque = sc.nextDouble();

            if (tipoConta == 'c') {
                listContas.add(new ContaCorrente(numero, nome, saldo, limiteSaque, TipoConta.CORRENTE, tipoPessoa == 'f' ? TipoPessoa.FISICA : TipoPessoa.JURIDICA));
            } else {
                listContas.add(new ContaPoupanca(numero, nome, saldo, limiteSaque, TipoConta.POUPANCA, tipoPessoa == 'f' ? TipoPessoa.FISICA : TipoPessoa.JURIDICA));
            }
        }

        System.out.println();

        System.out.println("Informação das contas: ");

        for (Conta conta : listContas) {
            System.out.println(conta.toString());
        }

        System.out.println();

        try {
            for (Conta conta : listContas) {
                System.out.println();

                System.out.print("Deseja realizar uma movimentação na conta do portador " + conta.getDono() + " (s/n)?");
                char resposta = sc.next().charAt(0);

                if (resposta == 's') {
                    System.out.print("Deseja realizar um saque ou depósito (s/d)? ");
                    char respostaMov = sc.next().charAt(0);

                    if (respostaMov == 'd') {
                        System.out.print("Informe o valor que deseja depositar: ");
                        double valorDeposito = sc.nextDouble();
                        conta.deposito(valorDeposito);
                    } else if (respostaMov == 's') {
                        System.out.print("Informe o valor que deseja sacar: ");
                        double valorSaque = sc.nextDouble();
                        conta.saque(valorSaque);
                    }
                }
            }
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        System.out.println("Informação atualizada das contas: ");

        for (Conta conta : listContas) {
            System.out.println(conta.toString());
        }

        System.out.println();
    }
}
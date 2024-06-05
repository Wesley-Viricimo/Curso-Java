package org.example;

import org.example.entities.Pessoa;
import org.example.entities.PessoaFisica;
import org.example.entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();

        System.out.print("Informe a quantidade de contribuintes: ");
        int quantidade = sc.nextInt();

        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Pessoa física ou jurídica (f/j) ?");
            char pessoa = sc.next().charAt(0);

            System.out.print("Nome: ");
            String nome = sc.next();

            System.out.print("Renda anual: ");
            double renda = sc.nextDouble();

            if (pessoa == 'f') {
                System.out.print("Gasto com saúde: ");
                double gastoSaude = sc.nextDouble();

                pessoas.add(new PessoaFisica(nome, renda, gastoSaude));
            } else {
                System.out.print("Número de funcionários: ");
                int funcionarios = sc.nextInt();

                pessoas.add(new PessoaJuridica(nome, renda, funcionarios));
            }
        }

        System.out.println();
        System.out.println("TAXAS DE IMPOSTO: ");

        double impostoTotal = 0;
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome() + ": $" + String.format("%.2f", pessoa.calculaImposto()));
            impostoTotal += pessoa.calculaImposto();
        }

        System.out.println();
        System.out.println("TOTAL DE IMPOSTOS: $ " + String.format("%.2f", impostoTotal));

        sc.close();
    }
}
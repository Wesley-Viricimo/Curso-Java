package org.example;

import org.example.entities.Funcionario;
import org.example.entities.FuncionarioTerceirizado;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a quantidade de funcionários: ");
        int quantidadeFuncionarios = sc.nextInt();
        List<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 1; i <= quantidadeFuncionarios; i++) {
            System.out.println("Informe os dados do " + i + "° Funcionário: ");

            System.out.print("Funcionário terceirizado (s/n)? ");
            String resposta = sc.next();

            System.out.print("Nome: ");
            String nome = sc.next();

            System.out.print("Horas: ");
            int horas = sc.nextInt();

            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();

            if (resposta.equals("s")) {
                System.out.print("Valor adicional: ");
                double valorAdicional = sc.nextDouble();
                funcionarios.add(new FuncionarioTerceirizado(nome, horas, valorPorHora, valorAdicional));
            } else {
                funcionarios.add(new Funcionario(nome, horas, valorPorHora));
            }
        }

        System.out.println();
        System.out.println("PAGAMENTOS: ");

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - $ " + String.format("%.2f", funcionario.pagamento()));
        }
        sc.close();
    }
}
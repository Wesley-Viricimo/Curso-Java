package org.example;

import org.example.entities.ContratoHora;
import org.example.entities.Departamento;
import org.example.entities.Trabalhador;
import org.example.entities.enums.LevelTrabalhador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Informe o departamento do trabalhador: ");
        String nomeDepartamento = sc.nextLine();

        System.out.println("Informe os dados do trabalhador: ");
        System.out.print("Nome: ");
        String nomeTrabalhador = sc.nextLine();

        System.out.print("Nível: ");
        String levelTrabalhador = sc.nextLine();

        System.out.print("Salário base: ");
        double salarioBase = sc.nextDouble();

        Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, LevelTrabalhador.valueOf(levelTrabalhador), salarioBase, new Departamento(nomeDepartamento));

        System.out.println("Quantos contratos este trabalhador possui? ");
        int quantidadeContratos = sc.nextInt();

        for (int i = 1; i <= quantidadeContratos; i++) { //Percorrendo por todos os contratos de acordo com a quantidade que o usuário digitou
            System.out.println("Informe o #" + i + " contrato:");
            System.out.print("Data (DD/MM/YYYY): ");
            Date dataContrato = sdf.parse(sc.next());

            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();

            System.out.print("Duração do contrato (em horas): ");
            int horas = sc.nextInt();

            ContratoHora contrato = new ContratoHora(dataContrato, valorPorHora, horas); //Instânciando o contrato de acordo com as informações que foram enviadas

            trabalhador.addContract(contrato);                                           //Associando o contrato ao trabalhador
        }

        System.out.println("Informe o mês e ano para cálculo do salário (MM/YYYY): ");
        String mesAno = sc.next();
        int mes = Integer.parseInt(mesAno.substring(0, 2));
        int ano = Integer.parseInt(mesAno.substring(3));

        System.out.println("Nome do trabalhador: " + trabalhador.getNome());
        System.out.println("Departamento do trabalhador: " + trabalhador.getDepartamento().getNome());
        System.out.println("Renda no mês " + mesAno + ": " + String.format("%.2f", trabalhador.renda(ano, mes, false)));

        System.out.println("Renda dos meses restantes: "+ String.format("%.2f", trabalhador.renda(ano, mes, true)));
    }
}
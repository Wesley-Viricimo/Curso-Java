package org.example;

import org.example.entities.Contrato;
import org.example.entities.Parcela;
import org.example.services.ContratoService;
import org.example.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Informe os dados do contrato:");

        System.out.print("Número: ");
        int numero = sc.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(sc.next(), dtf);

        System.out.print("Valor do contrato: ");
        double valorTotal = sc.nextDouble();

        Contrato contrato = new Contrato(numero, data, valorTotal);

        System.out.print("Informe a quantidade de parcelas: ");
        int qtde = sc.nextInt();

        ContratoService contratoService = new ContratoService(new PaypalService());

        contratoService.processarContrato(contrato, qtde);

        System.out.println("Parcelas: ");
        for (Parcela parcela : contrato.getParcelas()) {
            System.out.println(parcela);
        }

        sc.close();
    }
}
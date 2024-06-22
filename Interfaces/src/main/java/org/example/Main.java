package org.example;

import org.example.model.entities.AluguelCarro;
import org.example.model.entities.Veiculo;
import org.example.model.services.AluguelService;
import org.example.model.services.ImpostoBrasilService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Informe os dados do aluguel: ");

        System.out.print("Modelo do carro: ");
        String modeloCarro = sc.next();

        System.out.print("Qual data e hora da retirada do carro (dd/MM/yyyy HH:mm): ");
        LocalDateTime inicio = LocalDateTime.parse(sc.next(), dtf);

        System.out.print("Qual data e hora do retorno do carro (dd/MM/yyyy HH:mm): ");
        LocalDateTime retorno = LocalDateTime.parse(sc.next(), dtf);

        AluguelCarro aluguelCarro = new AluguelCarro(inicio, retorno, new Veiculo(modeloCarro));

        System.out.print("Informe o preço por hora: ");
        double valorHora = sc.nextDouble();

        System.out.print("Informe o preço por dia: ");
        double valorPorDia = sc.nextDouble();

        AluguelService aluguelService = new AluguelService(valorHora, valorPorDia, new ImpostoBrasilService());

        aluguelService.processarFatura(aluguelCarro);

        System.out.println();
        System.out.println("FATURA: ");

        System.out.println("Pagamento básico: " + aluguelCarro.getFatura().getPagamentoBasico());
        System.out.println("Imposto: " + aluguelCarro.getFatura().getImposto());
        System.out.println("Pagamento total: " + aluguelCarro.getFatura().getPagamentoTotal());

        sc.close();
    }
}
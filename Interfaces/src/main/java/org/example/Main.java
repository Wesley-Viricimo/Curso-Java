package org.example;

import org.example.model.entities.AluguelCarro;
import org.example.model.entities.Veiculo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

        System.out.println("Informe os dados do aluguel: ");

        System.out.print("Modelo do carro: ");
        String modeloCarro = sc.next();

        System.out.print("Qual data e hora da retirada do carro (ddMM/yyyy HH:mm): ");
        LocalDateTime inicio = LocalDateTime.parse(sc.next(), dtf);

        System.out.print("Qual data e hora do retorno do carro (ddMM/yyyy HH:mm): ");
        LocalDateTime retorno = LocalDateTime.parse(sc.next(), dtf);

        AluguelCarro aluguelCarro = new AluguelCarro(inicio, retorno, new Veiculo(modeloCarro));



        sc.close();
    }
}
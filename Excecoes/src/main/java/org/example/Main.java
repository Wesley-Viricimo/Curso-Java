package org.example;

import org.example.model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int numero = sc.nextInt();

        System.out.print("Informe a data de entrada (dd/MM/yyyy): ");
        Date dataEntrada = sdf.parse(sc.next());

        System.out.print("Informe a data de saída (dd/MM/yyyy): ");
        Date dataSaida = sdf.parse(sc.next());

        if (!dataSaida.after(dataEntrada)) {
            System.out.print("Erro na reserva: Data de saída deve ser maior que a data de entrada!");
        } else {
            Reserva reserva = new Reserva(numero, dataEntrada, dataSaida);
            System.out.print("Reserva: " + reserva);

            System.out.println();
            System.out.println("Informe os dados para atualizar a reserva: ");

            System.out.print("Informe a data de entrada (dd/MM/yyyy): ");
            dataEntrada = sdf.parse(sc.next());

            System.out.print("Informe a data de saída (dd/MM/yyyy): ");
            dataSaida = sdf.parse(sc.next());


            String erro = reserva.atualizarDatas(dataEntrada, dataSaida);
            if (erro != null) {
                System.out.println(erro);
            } else {
                System.out.print("Reserva: " + reserva);
            }
        }

        sc.close();
    }
}
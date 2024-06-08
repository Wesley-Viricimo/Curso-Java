package org.example;

import org.example.model.entities.Reserva;
import org.example.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int numero = sc.nextInt();

            System.out.print("Informe a data de entrada (dd/MM/yyyy): ");
            Date dataEntrada = sdf.parse(sc.next());

            System.out.print("Informe a data de saída (dd/MM/yyyy): ");
            Date dataSaida = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numero, dataEntrada, dataSaida);
            System.out.print("Reserva: " + reserva);

            System.out.println();
            System.out.println("Informe os dados para atualizar a reserva: ");

            System.out.print("Informe a data de entrada (dd/MM/yyyy): ");
            dataEntrada = sdf.parse(sc.next());

            System.out.print("Informe a data de saída (dd/MM/yyyy): ");
            dataSaida = sdf.parse(sc.next());

            reserva.atualizarDatas(dataEntrada, dataSaida);
            System.out.print("Reserva: " + reserva);
        }
        catch (ParseException e) {
            System.out.println("Formato de data inválido!");
        }
        catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Um erro inesperado ocorreu!");
        }

        sc.close();
    }
}
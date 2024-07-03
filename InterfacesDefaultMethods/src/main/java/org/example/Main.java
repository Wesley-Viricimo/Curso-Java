package org.example;

import org.example.services.ImpostoService;
import org.example.services.ImpostoUsaService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor: ");
        double valor = sc.nextDouble();

        System.out.print("Meses: ");
        int meses = sc.nextInt();

        ImpostoService is = new ImpostoUsaService(1.0);
        double pagamento = is.pagamento(valor, meses);

        System.out.println("Pagamento após " + meses + " meses: ");
        System.out.println(String.format("%.2f", pagamento));

        sc.close();
    }
}
package org.example;

import org.example.entities.Circulo;
import org.example.entities.Forma;
import org.example.entities.Retangulo;
import org.example.entities.enums.Cor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Forma> formas = new ArrayList<>();

        System.out.print("Informe o número de formas: ");
        int quantidade = sc.nextInt();

        for(int i = 1; i <= quantidade; i++) {
            System.out.println("Informe os dados da " + i + "° forma: ");
            System.out.print("É um retângulo ou um circulo (r/c)? ");
            char ch = sc.next().charAt(0);

            System.out.print("Cor (PRETO/AZUL/VERMELHO): ");
            Cor cor = Cor.valueOf(sc.next());

            if (ch == 'r') {
                System.out.print("Largura: ");
                double largura = sc.nextDouble();

                System.out.print("Altura: ");
                double altura = sc.nextDouble();

                formas.add(new Retangulo(cor, largura, altura));
            } else {
                System.out.print("Raio: ");
                double raio = sc.nextDouble();
                

                formas.add(new Circulo(cor, raio));
            }
        }

        System.out.println();
        System.out.println("ÁREA DAS FORMAS: ");

        for (Forma forma : formas) {
            System.out.println(String.format("%.2f", forma.area()));
        }

        sc.close();
    }
}
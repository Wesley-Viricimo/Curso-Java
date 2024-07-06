package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> votes = new LinkedHashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(","); //Dividir a linha do arquivo a partir da virgula
                String name = fields[0]; //Ante da virgula obtenho o nome
                int count = Integer.parseInt(fields[1]); //Depois da virgula obtenho a quantidade de votos

                if (votes.containsKey(name)) { //Se o meu map já possuir a chave com o nome do candidato
                    int votesSoFar = votes.get(name); //Obtenho a quantidade de votos que esse candidado já possui
                    votes.put(name, count + votesSoFar); //Insiro no meu map o candidato e os votos das linhas anteriores com os votos da nova linha
                }
                else { //Se o meu map não possuir a chave com o nome do candidato, só insiro no map
                    votes.put(name, count);
                }

                line = br.readLine();
            }

            for (String key : votes.keySet()) { //Percorrer as chaves existentes no map e retornar o nome do candidato com a quantidade de votos
                System.out.println(key + ": " + votes.get(key));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
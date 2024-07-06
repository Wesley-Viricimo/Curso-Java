package org.example;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, String> cookies = new TreeMap<>(); //TreeMap é um map com ordenação, como a chave é string, será ordenado por ordem alfabética

        cookies.put("username", "Maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "99711122");

        cookies.put("phone", "99711124"); //Se houver uma inserção no map com uma mesma chave, a segunda sobrescreve a primeira, pois não são permitidas chaves repetidas

        cookies.remove("email");

        System.out.println("Contais 'phone' key: " + cookies.containsKey("phone")); //ContaisKey realiza busca pela chave do map
        System.out.println("Phone number" + cookies.get("phone")); //Get retorna o valor de um map realizando a busca pela chave
        System.out.println("Email: " + cookies.get("email")); //Se for realizada uma busca utilizando uma chave que não exista, irá retornar nulo

        System.out.println("All cookies: ");

        for (String key : cookies.keySet()) { //KeySet retorna todas as chaves do map
            System.out.println(key + ": " + cookies.get(key));
        }
    }
}
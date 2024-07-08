package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        int sum = list.stream().reduce(0, (x, y) -> x + y);

        System.out.println("Sum = " + sum);

        List<Integer> newList = list.stream() //PEGO A MINHA LISTA E TRANSFORMO EM UMA STREAM
                .filter(x -> x % 2 == 0)      //REALIZO UM FILTRO PARA FILTRAR APENAS PELOS NÚMEROS PARES
                .map(x -> x * 10)             //REALIZO UMA OPERAÇÃO NO MAP MULTIPLICANDO OS ELEMENTOS DA STREAM POR 10
                .toList();                    //COLETO OS ELEMENTOS DA STREAM E CONVERTO PARA LISTA

        System.out.println(Arrays.toString(newList.toArray()));
    }
}
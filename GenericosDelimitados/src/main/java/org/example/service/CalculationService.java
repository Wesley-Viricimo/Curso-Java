package org.example.service;

import java.util.List;

public class CalculationService {
    public static <T extends Comparable<T>> T max(List<T> list) { //<T> indica que esse método irá trabalhar com algum tipo T (genérico), método também irá retornar um tipo genérico e também recebe uma lista de tipo genérico como parâmetro
        if (list.isEmpty()) {
            throw new IllegalStateException("Lista é vazia!");
        }
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
}

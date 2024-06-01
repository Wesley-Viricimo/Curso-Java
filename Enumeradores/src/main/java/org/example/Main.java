package org.example;

import org.example.entities.Pedido;
import org.example.entities.enums.StatusPedido;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(1080, new Date(), StatusPedido.PROCESSANDO);
        System.out.println(pedido);
    }
}
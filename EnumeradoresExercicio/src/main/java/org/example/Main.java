package org.example;

import org.example.entities.Cliente;
import org.example.entities.ItensPedido;
import org.example.entities.Pedido;
import org.example.entities.Produto;
import org.example.entities.enums.StatusPedido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Informe os dados do cliente: ");
        System.out.print("Nome: ");
        String nomeCliente = sc.nextLine();

        System.out.print("Email: ");
        String emailCliente = sc.nextLine();

        System.out.print("Data aniversário (DD/MM/YYYY): ");
        Date dataAniversario = sdf.parse(sc.next());

        Cliente cliente = new Cliente(nomeCliente, emailCliente, dataAniversario);

        System.out.println();
        System.out.println("Informe os dados do pedido: ");

        System.out.print("Status do pedido: ");
        String statusPedido = sc.next();

        System.out.print("Quantos itens deseja comprar? ");
        int quantidade = sc.nextInt();

        Pedido pedido = new Pedido(new Date(), cliente, StatusPedido.valueOf(statusPedido));

        for (int i = 1; i <= quantidade; i++) {
            System.out.println("Informe os dados do " + i + "° item: ");
            System.out.print("Nome do produto: ");
            String nomeProduto = sc.next();
            System.out.print("Preco do produto: ");
            double precoProduto = sc.nextDouble();
            System.out.print("Quantidade: ");
            int quantidadeVendida = sc.nextInt();

            ItensPedido itensPedido = new ItensPedido(new Produto(nomeProduto, precoProduto), quantidadeVendida);
            pedido.addItem(itensPedido);
        }

        System.out.println();

        System.out.println("Sumário do pedido: ");
        System.out.println("Data do pedido: " + sdf.format(pedido.getDataPedido()));
        System.out.println("Cliente: " + pedido.getCliente().getNome() + " " + sdf.format(pedido.getCliente().getDataAniversario()) + " - " + pedido.getCliente().getEmail());
        System.out.println("Itens do pedido: ");

        for (ItensPedido item : pedido.getItensPedido()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(item.getProduto().getNome() + ", ");
            stringBuilder.append("$" + String.format("%.2f", item.getProduto().getPreco()) + ", ");
            stringBuilder.append("Quantidade: " + item.getQuantidade() + ", ");
            stringBuilder.append("Subtotal: $" + String.format("%.2f", item.getSubtotal()) + "\n");
            System.out.print(stringBuilder);
        }
        System.out.print("Valor total do pedido: $" + String.format("%.2f", pedido.getTotal()));
    }
}
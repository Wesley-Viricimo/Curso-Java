package org.example;

import org.example.entities.Produto;
import org.example.entities.ProdutoImportado;
import org.example.entities.ProdutoUsado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Produto> produtos = new ArrayList<>();

        System.out.print("Informe a quantidade de produtos: ");
        int quantidadeProdutos = sc.nextInt();

        for (int i = 1; i <= quantidadeProdutos; i++) {
            System.out.println("Informe os dados do " + i + "° produto: ");

            System.out.print("O produto é comum, usado ou importado (c/u/i)? ");
            String resposta = sc.next();

            System.out.print("Nome do produto: ");
            String nome = sc.next();

            System.out.print("Preço do produto: ");
            double preco = sc.nextDouble();

            if (resposta.equals("i")) {
                System.out.print("Custo de importação: ");
                double custoImportacao = sc.nextDouble();
                produtos.add(new ProdutoImportado(nome, preco, custoImportacao));
            } else if(resposta.equals("u")) {
                System.out.print("Data de fabricação (DD/MM/YYYY): ");
                Date dataFabricacao = sdf.parse(sc.next());
                produtos.add(new ProdutoUsado(nome, preco, dataFabricacao));
            } else {
                produtos.add(new Produto(nome, preco));
            }
        }

        System.out.println();
        System.out.println("ETIQUETAS DE PREÇO: ");

        for (Produto produto : produtos) {
            System.out.println(produto.etiquetaPreco());
        }
    }
}
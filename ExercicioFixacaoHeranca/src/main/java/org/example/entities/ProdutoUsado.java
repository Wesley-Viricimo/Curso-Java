package org.example.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {
    private Date dataFabricacao;

    public ProdutoUsado() {
    }

    public ProdutoUsado(String nome, double preco, Date dataFabricacao) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String etiquetaPreco() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return nome
                + " (usado)"
                + " $ " + String.format("%.2f", preco)
                + " (Data de fabricação: "
                + sdf.format(dataFabricacao)
                + ")";
    }
}

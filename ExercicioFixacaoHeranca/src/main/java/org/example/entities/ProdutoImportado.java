package org.example.entities;

public class ProdutoImportado extends Produto {
    private double custoImportacao;

    public ProdutoImportado() {
    }

    public ProdutoImportado(String nome, double preco, double custoImportacao) {
        super(nome, preco);
        this.custoImportacao = custoImportacao;
    }

    public double getCustoImportacao() {
        return custoImportacao;
    }

    public void setCustoImportacao(double custoImportacao) {
        this.custoImportacao = custoImportacao;
    }

    @Override
    public String etiquetaPreco() {
        return super.etiquetaPreco()
                + " (Custo de importação: $ "
                + String.format("%.2f", custoImportacao)
                + ")";
    }
}

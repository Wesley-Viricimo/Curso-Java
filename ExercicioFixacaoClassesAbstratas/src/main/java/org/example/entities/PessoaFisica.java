package org.example.entities;

public class PessoaFisica extends Pessoa {

    private double gastosSaude;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double calculaImposto() {
        double imposto;
        if (rendaAnual >= 20000.00) {
            imposto = rendaAnual * 0.25;
        } else {
            imposto = rendaAnual * 0.15;
        }

        if (gastosSaude > 0) {
            imposto -= gastosSaude * 0.50;
        }

        return imposto;
    }
}

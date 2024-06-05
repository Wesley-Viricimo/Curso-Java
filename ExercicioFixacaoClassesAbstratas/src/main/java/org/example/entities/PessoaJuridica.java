package org.example.entities;

public class PessoaJuridica extends Pessoa {

    private Integer numeroFuncionarios;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, double rendaAnual, Integer numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double calculaImposto() {
        double imposto;
        if (numeroFuncionarios > 10) {
            imposto = rendaAnual * 0.14;
        } else {
            imposto = rendaAnual * 0.16;
        }

        return imposto;
    }
}

package org.example.entities;

public final class FuncionarioTerceirizado extends Funcionario {
    private double adicionalExtra;

    public FuncionarioTerceirizado() {
    }

    public FuncionarioTerceirizado(String nome, Integer horas, double valorPorHora, double adicionalExtra) {
        super(nome, horas, valorPorHora);
        this.adicionalExtra = adicionalExtra;
    }

    public double getAdicionalExtra() {
        return adicionalExtra;
    }

    public void setAdicionalExtra(double adicionalExtra) {
        this.adicionalExtra = adicionalExtra;
    }

    @Override
    public double pagamento() {
        return horas * valorPorHora + (adicionalExtra * 1.1);
    }
}

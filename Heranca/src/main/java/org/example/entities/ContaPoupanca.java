package org.example.entities;

public final class ContaPoupanca extends Conta {  //Classes com final não poderão ser herdadas
    private double taxaJuros;

    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(Integer numero, String proprietario, double saldo, double taxaJuros) {
        super(numero, proprietario, saldo);
        this.taxaJuros = taxaJuros;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public void atualizarSaldo() {
        saldo += saldo * taxaJuros;
    }

    @Override //Anotação indica que estou sobrecresvendo o método saque da superclasse
    public void saque(double valor) {
        saldo -= valor;
    }
}

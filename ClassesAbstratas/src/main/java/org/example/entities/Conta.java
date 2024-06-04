package org.example.entities;

public abstract class Conta { //Classes abstratas não podem ser instânciadas;

    private Integer numero;
    private String proprietario;
    protected double saldo;

    public Conta() {
    }

    public Conta(Integer numero, String proprietario, double saldo) {
        this.numero = numero;
        this.proprietario = proprietario;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void saque(double valor) {
        saldo -= valor + 5.0;
    }

    public void deposito(double valor) {
        saldo += valor;
    }
}

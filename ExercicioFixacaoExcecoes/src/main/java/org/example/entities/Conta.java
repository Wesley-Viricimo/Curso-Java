package org.example.entities;

public class Conta {
    private Integer numero;
    private String dono;
    private double saldo;
    private double limiteSaque;

    public Conta() {
    }

    public Conta(Integer numero, String dono, double saldo, double limiteSaque) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteSaque() {
        return limiteSaque;
    }

    public void saque(double valor) {
        if (valor > limiteSaque) {
            throw new IllegalArgumentException("Valor de saque solicitado excede o máximo permitido!");
        } else if (valor > saldo) {
            throw new IllegalArgumentException("Valor indisponível para saque!");
        } else {
            saldo = saldo - valor;
        }
    }
}

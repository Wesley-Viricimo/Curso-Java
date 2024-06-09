package org.example.entities;

import org.example.entities.enums.TipoConta;
import org.example.exceptions.DomainException;

public abstract class Conta {
    private Integer numero;
    private String dono;
    public double saldo;
    public double limiteSaque;
    private TipoConta tipoConta;

    public Conta() {
    }

    public Conta(Integer numero, String dono, double saldo, double limiteSaque, TipoConta tipoConta) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
        this.tipoConta = tipoConta;
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

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public abstract void deposito(double valor);

    public abstract void saque(double valor) throws DomainException;
}

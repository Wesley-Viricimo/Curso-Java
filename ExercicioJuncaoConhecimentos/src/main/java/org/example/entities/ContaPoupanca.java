package org.example.entities;

import org.example.entities.enums.TipoConta;
import org.example.entities.enums.TipoPessoa;
import org.example.exceptions.DomainException;

public class ContaPoupanca extends Conta {
    private TipoPessoa tipoPessoa;

    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(Integer numero, String dono, double saldo, double limiteSaque, TipoConta tipoConta, TipoPessoa tipoPessoa) {
        super(numero, dono, saldo, limiteSaque, tipoConta);
        this.tipoPessoa = tipoPessoa;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    @Override
    public void deposito(double valor) {
        if (tipoPessoa == TipoPessoa.FISICA) {
            saldo = saldo + (valor * 0.15); //Contas de pessoa física recebem 15% do valor depositado enquanto pessoas juridicas recebem 20%
        } else {
            saldo = saldo + (valor * 0.20);
        }
    }

    @Override
    public void saque(double valor) throws DomainException {
        if (valor > limiteSaque) {
            throw new DomainException("Valor de saque solicitado é maior que o limite permitido!");
        } else if (valor > saldo) {
            throw new DomainException("Valor de saque solicitado é maior que o saldo na conta!");
        } else {
            if (tipoPessoa == TipoPessoa.FISICA) {
                saldo = saldo - valor;
            } else {
                saldo = saldo - (valor * 0.05); //Pessoa jurídica terá um juros de 5% ao realizar saques da conta poupança
            }
        }
    }

    @Override
    public String toString() {
        return  "Conta: " + getNumero()
                + ", Titular da conta: "
                + getDono()
                + ", Tipo pessoa: "
                + getTipoPessoa()
                + ", Tipo da conta: "
                + getTipoConta()
                + ", Saldo na conta: "
                + String.format("%.2f", getSaldo());
    }
}

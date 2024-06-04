package org.example.entities;

public class ContaComercial extends Conta {
    private double limiteEmprestimo;

    public ContaComercial() {
        super(); //Realizará a chamada do construtor sem argumentos da superclasse ou classe pai
    }

    public ContaComercial(Integer numero, String proprietario, double saldo, double limiteEmprestimo) {
        super(numero, proprietario, saldo); //Realizará a chamada do construtor com argumentos da superclasse ou classe pai
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public double getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void emprestimo(double valor) {
        if (valor <= limiteEmprestimo) {
            saldo += valor - 10.0;
        }
    }

    @Override //Anotação indica que estou sobrecresvendo o método saque da superclasse
    public void saque(double valor) {
        super.saque(valor); //Chamo o método saque da superclasse
        saldo -= 2.0;       //Acrescento uma caracteristica específica de contas comerciais
    }
}

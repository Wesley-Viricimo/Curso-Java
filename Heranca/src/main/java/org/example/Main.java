package org.example;

import org.example.entities.Conta;
import org.example.entities.ContaComercial;
import org.example.entities.ContaPoupanca;

public class Main {
    public static void main(String[] args) {

        Conta conta = new Conta(1001, "Wesley", 0);
        ContaComercial contaComercial = new ContaComercial(1002, "Jessica", 0 , 500);
        Conta contaPoupanca = new ContaPoupanca(1003, "Maria", 0, 500);

        //UPCASTING
        Conta conta1 = contaComercial; //É possível atribuir uma variável de um objeto de uma subclasse para uma variável de um da superclasse

        //DOWNCASTING
        ContaComercial contaComercial1 = (ContaComercial) conta1; //Somente é possível atribuir uma variável de um objeto de uma superclasse para uma variável de um objeto de subclasse realizando um cast (conversão)
        contaComercial1.emprestimo(100.0);

        //ContaComercial contaComercial2 = (ContaComercial) contaPoupanca; //Geraria um erro em tempo de compilação, pois uma conta poupança é diferente de uma conta comercial

        if (contaPoupanca instanceof ContaComercial) { //Verifica se a conta poupança é uma instância de uma conta comercial
            ContaComercial contaComercial2 = (ContaComercial) contaPoupanca;
            contaComercial2.emprestimo(200.0);
            System.out.println("Empréstimo");
        }

        if (contaPoupanca instanceof ContaPoupanca) {
            ContaPoupanca contaPoupanca1 = (ContaPoupanca) contaPoupanca;
            contaPoupanca1.atualizarSaldo();
            System.out.println("Atualiza saldo!");
        }
    }
}
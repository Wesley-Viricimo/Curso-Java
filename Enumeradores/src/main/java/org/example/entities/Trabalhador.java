package org.example.entities;

import org.example.entities.enums.LevelTrabalhador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {
    private String nome;
    private LevelTrabalhador level;
    private double salarioBase;
    private Departamento departamento;
    private List<ContratoHora> contratos = new ArrayList<>();

    public Trabalhador() {
    }

    public Trabalhador(String nome, LevelTrabalhador level, double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.level = level;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LevelTrabalhador getLevel() {
        return level;
    }

    public void setLevel(LevelTrabalhador level) {
        this.level = level;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoHora> getContratos() {
        return contratos;
    }

    public void addContract(ContratoHora contrato) {
        contratos.add(contrato);
    }

    public void removeContract(ContratoHora contrato) {
        contratos.remove(contrato);
    }

    public double renda(int ano, int mes) {
        double soma = salarioBase;
        Calendar cal = Calendar.getInstance();              //Obtendo a instância de calendário
        for (ContratoHora contrato : contratos) {           //Percorrer toda a lista de contratos

            cal.setTime(contrato.getData());                //Setando no calendário a data do contrato
            int anoContrato = cal.get(Calendar.YEAR);       //Obtendo o ano do contrato e atribuindo a variável
            int mesContrato = 1 + cal.get(Calendar.MONTH);  //Obtendo o mês do contrato e atribuindo a variável (somando com mais 1 pois os meses do calendar vão de 0 a 11)

            if (ano == anoContrato && mes == mesContrato) { //Se o contrato for do ano e mês informados
                soma += contrato.valorTotal();              //Obter o valor total do contrato e atribuir a variável
            }
        }
        return soma;
    }
}

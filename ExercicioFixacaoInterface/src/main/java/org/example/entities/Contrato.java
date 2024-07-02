package org.example.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {

    private Integer numero;
    private LocalDate data;
    private double valorTotal;
    private List<Parcela> parcelas = new ArrayList<>(); //Contrato poderá ter várias parcelas

    public Contrato() {
    }

    public Contrato(Integer numero, LocalDate data, double valorTotal) {
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }
}

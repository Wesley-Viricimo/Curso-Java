package org.example.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate data;
    private double valor;

    public Parcela() {
    }

    public Parcela(LocalDate data, double valor) {
        this.data = data;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return  data.format(dtf) +
                " - " +
                String.format("%.2f", valor);
    }
}

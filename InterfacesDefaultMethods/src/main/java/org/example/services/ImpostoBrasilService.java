package org.example.services;

public class ImpostoBrasilService implements ImpostoService {

    private double taxaJuros;

    public ImpostoBrasilService(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    @Override
    public double getTaxaJuros() {
        return taxaJuros;
    }
}

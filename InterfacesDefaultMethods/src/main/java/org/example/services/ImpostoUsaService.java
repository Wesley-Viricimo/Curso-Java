package org.example.services;

public class ImpostoUsaService implements ImpostoService {

    private double taxaJuros;

    public ImpostoUsaService(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    @Override
    public double getTaxaJuros() {
        return taxaJuros;
    }
}

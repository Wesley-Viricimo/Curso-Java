package org.example.model.services;

public class ImpostoBrasilService implements ImpostoService{

    public double imposto(double valor) {
        if (valor <= 100) {
            return valor * 0.2;
        } else {
            return valor * 0.15;
        }
    }
}

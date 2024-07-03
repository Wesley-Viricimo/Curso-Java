package org.example.services;

import java.security.InvalidParameterException;

public interface ImpostoService {

    double getTaxaJuros();

    default double pagamento(double valor, int meses) {
        if (meses < 1) {
            throw new InvalidParameterException("Months must be greater than zero");
        }
        return valor * Math.pow(1.0 + getTaxaJuros() / 100, meses);
    }
}

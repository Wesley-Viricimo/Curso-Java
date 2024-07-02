package org.example.services;

import org.example.entities.Contrato;
import org.example.entities.Parcela;

import java.time.LocalDate;

public class ContratoService {
    private PagamentoOnlineService pagamentoOnlineService;

    public ContratoService(PagamentoOnlineService pagamentoOnlineService) {
        this.pagamentoOnlineService = pagamentoOnlineService;
    }

    public void processarContrato(Contrato contrato, int meses) {

        contrato.getParcelas().add(new Parcela(LocalDate.of(2018, 7, 25), 206.04));
        contrato.getParcelas().add(new Parcela(LocalDate.of(2018, 8, 25), 208.08));
    }
}

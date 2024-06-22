package org.example.model.services;

import org.example.model.entities.AluguelCarro;
import org.example.model.entities.Fatura;

import java.time.Duration;

public class AluguelService {

    private double precoPorHora;
    private double precoPorDia;
    private ImpostoService impostoBrasilService;

    public AluguelService(double precoPorHora, double precoPorDia, ImpostoService impostoBrasilService) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
        this.impostoBrasilService = impostoBrasilService;
    }

    public void processarFatura(AluguelCarro aluguelCarro) {

        double minutos = Duration.between(aluguelCarro.getInicio(), aluguelCarro.getFim()).toMinutes();
        double horas = minutos / 60;

        double pagamentoBasico;

        if(horas <= 12.0) {
            pagamentoBasico = precoPorHora * Math.ceil(horas); //Math.ceil arredonda para cima
        } else {
            pagamentoBasico = precoPorDia * Math.ceil(horas / 24);
        }

        double imposto = impostoBrasilService.imposto(pagamentoBasico);

        aluguelCarro.setFatura(new Fatura(pagamentoBasico,imposto));
    }
}

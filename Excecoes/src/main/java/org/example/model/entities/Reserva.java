package org.example.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date dataEntrada;
    private Date dataSaida;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public long duracao() {
        long diferenca = dataSaida.getTime() - dataEntrada.getTime(); //OBTER DIFERENÇA ENTRE DATAS EM MILI SEGUNDOS
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); //CONVERTE A DIFERENÇA ENTRE A DATA DE ENTRADA E DATA DE SAIDA EM DIAS
    }

    public void updateDates(Date dataEntrada, Date dataSaida) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString() {
        return "Quarto "
                + numeroQuarto
                + ", data de entrada: "
                + sdf.format(dataEntrada)
                + ", data de saída: "
                + sdf.format(dataSaida)
                + ", "
                + duracao()
                + " noites";
    }
}

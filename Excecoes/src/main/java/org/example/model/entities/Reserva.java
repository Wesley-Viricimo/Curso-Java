package org.example.model.entities;

import org.example.model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date dataEntrada;
    private Date dataSaida;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
        if (!dataSaida.after(dataEntrada)) {
            throw new DomainException("Data de saída deve ser maior que a data de entrada!");
        }
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

    public void atualizarDatas(Date dataEntrada, Date dataSaida) {
        Date agora = new Date();
        if (dataEntrada.before(agora) || dataSaida.before(agora)) {
            throw new DomainException("As datas de reserva para atualização devem ser futuras!");
        }
        if (!dataSaida.after(dataEntrada)) {
            throw new DomainException("Data de saída deve ser maior que a data de entrada!");
        }

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

package org.example.entities;

import org.example.entities.enums.Cor;

public abstract class Forma {

    private Cor cor;

    public Forma() {
    }

    public Forma(Cor cor) {
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public abstract double area(); //MÉTODOS ABSTRATOS DEVEM SER SOBRESCRITOS PELA SUBCLASSE QUE IRÁ EXTENDER
}

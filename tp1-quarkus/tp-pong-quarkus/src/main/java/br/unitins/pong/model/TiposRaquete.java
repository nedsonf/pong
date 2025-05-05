package br.unitins.pong.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TiposRaquete {
    INVERTIDAS("Invertidas"),
    PINOSCURTOS("Pinos Curtos"),
    PINOSLONGOS("Pinos Longos"),
    PINOSMEDIOS("Pinos Médios"),
    ANTISPIN("Antispin"),
    VELOCIDADE("Velocidade"),
    CONTROLE("Controle");

    private final String label;

    TiposRaquete(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

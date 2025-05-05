package br.unitins.pong.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class EspessuraBorracha extends DefaultEntity {

    @NotNull
    private Double espessura;

    // Getters e Setters
    public Double getEspessura() {
        return espessura;
    }

    public void setEspessura(Double espessura) {
        this.espessura = espessura;
    }
}

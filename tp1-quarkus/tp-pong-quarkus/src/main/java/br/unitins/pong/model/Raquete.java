package br.unitins.pong.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Raquete extends DefaultEntity {

    @NotBlank
    private String nome;

    @NotNull
    private Double preco;

    @NotNull
    private Integer estoqueDisponivel;

    @Enumerated(EnumType.STRING)
    private TiposRaquete tipo;

    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    private Fabricante fabricante;

    @ManyToOne
    @JoinColumn(name = "id_cor_borracha")
    private CorBorracha corBorracha;

    @ManyToOne
    @JoinColumn(name = "id_espessura_borracha")
    private EspessuraBorracha espessuraBorracha;

    @ManyToOne
    @JoinColumn(name = "id_lote")
    private Lote lote;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    public void setEstoqueDisponivel(Integer estoqueDisponivel) {
        this.estoqueDisponivel = estoqueDisponivel;
    }

    public TiposRaquete getTipo() {
        return tipo;
    }

    public void setTipo(TiposRaquete tipo) {
        this.tipo = tipo;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public CorBorracha getCorBorracha() {
        return corBorracha;
    }

    public void setCorBorracha(CorBorracha corBorracha) {
        this.corBorracha = corBorracha;
    }

    public EspessuraBorracha getEspessuraBorracha() {
        return espessuraBorracha;
    }

    public void setEspessuraBorracha(EspessuraBorracha espessuraBorracha) {
        this.espessuraBorracha = espessuraBorracha;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }
}

package br.unitins.tp1.pong.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Raquete extends DefaultEntity {

    @Column(nullable = false)
    private String NomeRaquete;

    private ;

    @Column(length = 400)
    private String descricao;

    private String codigo;

    private String imagemPrincipal;

    private String[] imagens;

    @Column(nullable = false)
    private Double precoVenda;

    @Column(nullable = false)
    private Double precoCusto;

    @Column(nullable = false)
    private Double desconto;

    @Column(nullable = false)
    private Integer quantidadeDisponivel;

    @Column(nullable = false)
    private Integer quantidadeVendido;

    private LocalDateTime dataDisponivel;

    private String nacionalidade;

    private String TempoDesgaste;

    // @Column(nullable = false)
    private StatusRaquete statusRaquete;

    // @Column(nullable = false)
    private exeperienciaExigida exeperienciaExigida;

    // @Column(nullable = false)
    private EspessuraBorracha EspessuraBorracha;

    // @Column(nullable = false)
    private  ;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Raquete_tag", joinColumns = @JoinColumn(name = "id_Raquete"), inverseJoinColumns = @JoinColumn(name = "id_tag"))
    private List<Tag> tags;


    @ManyToOne
    @JoinColumn(name = "id_categoriabiologica")
    private CategoriaRaquete categoriaBiologica;

    public String getNomeRaquete() {
        return NomeRaquete;
    }

    public void setNomeRaquete(String NomeRaquete) {
        this.NomeRaquete = NomeRaquete;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico() {
        this.nomeCientifico = nomeCientifico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getImagemPrincipal() {
        return imagemPrincipal;
    }

    public void setImagemPrincipal(String imagemPrincipal) {
        this.imagemPrincipal = imagemPrincipal;
    }

    public String[] getImagens() {
        return imagens;
    }

    public void setImagens(String[] imagens) {
        this.imagens = imagens;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Integer getQuantidadeVendido() {
        return quantidadeVendido;
    }

    public void setQuantidadeVendido(Integer quantidadeVendido) {
        this.quantidadeVendido = quantidadeVendido;
    }

    public LocalDateTime getDataDisponivel() {
        return dataDisponivel;
    }

    public void setDataDisponivel(LocalDateTime dataDisponivel) {
        this.dataDisponivel = dataDisponivel;
    }

    public String getnacionalidade() {
        return nacionalidade;
    }

    public void setnacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getTempoDesgaste() {
        return TempoDesgaste;
    }

    public void setTempoDesgaste(String TempoDesgaste) {
        this.TempoDesgaste = TempoDesgaste;
    }

    public StatusRaquete getStatusRaquete() {
        return statusRaquete;
    }

    public void setStatusRaquete(StatusRaquete statusRaquete) {
        this.statusRaquete = statusRaquete;
    }

    public exeperienciaExigida getexeperienciaExigida() {
        return exeperienciaExigida;
    }

    public void setexeperienciaExigida(exeperienciaExigida exeperienciaExigida) {
        this.exeperienciaExigida = exeperienciaExigida;
    }

    public EspessuraBorracha getEspessuraBorracha() {
        return EspessuraBorracha;
    }

    public void setEspessuraBorracha(EspessuraBorracha EspessuraBorracha) {
        this.EspessuraBorracha = EspessuraBorracha;
    }

 
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }



    public CategoriaRaquete getCategoriaBiologica() {
        return categoriaBiologica;
    }

    public void setCategoriaBiologica(CategoriaRaquete categoriaRaquete) {
        this.categoriaBiologica = categoriaRaquete;
    }


    
}

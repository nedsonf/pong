package br.unitins.tp1.pong.dto;

import java.util.List;

import br.unitins.tp1.pong.model.exeperienciaExigida;
import br.unitins.tp1.pong.model.EspessuraBorracha;
import br.unitins.tp1.pong.model.Raquete;
import br.unitins.tp1.pong.model.;


public record RaqueteRespondeDTO(

    Long id,
    String NomeRaquete,
    String descricao,
    String codigo,
    String imagemPrincipal,
    String[] imagens,
    Double precoVenda,
    Double precoCusto,
    Double desconto,
    Integer quantidadeDisponivel,
    Integer quantidadeVendido,
    String nacionalidade,
    String TempoDesgaste,
    StatusRaquete statusRaquete,
    exeperienciaExigida exeperienciaExigida,
    EspessuraBorracha EspessuraBorracha,
    
    CategoriaRaqueteRespondeDTO categoriaRaquete

  ) {
  public static RaqueteRespondeDTO valueOf(Raquete Raquete) {
    return new RaqueteRespondeDTO(
      Raquete.getId(),
      Raquete.getNomeRaquete(),
      Raquete.getNomeCientifico(),
      Raquete.getDescricao(),
      Raquete.getCodigo(),
      Raquete.getImagemPrincipal(),
      Raquete.getImagens(),
      Raquete.getPrecoVenda(),
      Raquete.getPrecoCusto(),
      Raquete.getDesconto(),
      Raquete.getQuantidadeDisponivel(),
      Raquete.getQuantidadeVendido(),
      Raquete.getnacionalidade(),
      Raquete.getTempoDesgaste(),
      Raquete.getStatusRaquete(),
      Raquete.getexeperienciaExigida(),
      Raquete.getEspessuraBorracha(),
      Raquete.get(),
      .valueOf(Raquete.getTags()),
      ResponseDTO.valueOf(Raquete.get()),
      CategoriaRaqueteRespondeDTO.valueOf(Raquete.getCategoriaBiologica())
    )
  }

}

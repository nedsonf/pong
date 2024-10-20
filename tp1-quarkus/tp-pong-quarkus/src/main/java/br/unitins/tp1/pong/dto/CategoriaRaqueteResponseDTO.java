package br.unitins.tp1.pong.dto;

import br.unitins.tp1.pong.model.CategoriaRquete;
import br.unitins.tp1.pong.model.TipoCategoria;

public record CategoriaRqueteResponseDTO(
    Long id,
    String nome,
    String descricao,
    Integer prioridade,
    Boolean ativa,
    TipoCategoria tipoCategoria) {

  public static CategoriaRqueteResponseDTO valueOf(CategoriaRquete categoriaRquete) {
    return new CategoriaRqueteResponseDTO(
        categoriaRquete.getId(),
        categoriaRquete.getNome(),
        categoriaRquete.getDescricao(),
        categoriaRquete.getPrioridade(),
        categoriaRquete.getAtiva(),
        categoriaRquete.getTipoCategoria());
  }

}

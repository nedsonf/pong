package br.unitins.tp1.pong.dto;

import br.unitins.tp1.pong.model.Cidade;
import br.unitins.tp1.pong.model.Estado;

public record CidadeResponseDTO(
    Long id,
    String nome,
    Estado estado,
    Double frete
) {
    public static CidadeResponseDTO valueOf(Cidade cidade){
        return new CidadeResponseDTO(
            cidade.getId(), 
            cidade.getNome(),
            cidade.getEstado(),
            cidade.getFrete());
    }
}

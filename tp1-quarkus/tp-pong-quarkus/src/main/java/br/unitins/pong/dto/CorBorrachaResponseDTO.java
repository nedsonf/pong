package br.unitins.pong.dto;

import java.time.LocalDateTime;

import br.unitins.pong.model.CorBorracha;

public record CorBorrachaResponseDTO(
    Long id,
    String nome,
    String cor,
    LocalDateTime dataCadastro,
    LocalDateTime dataAlteracao
) {
    public static CorBorrachaResponseDTO valueOf(CorBorracha c) {
        return new CorBorrachaResponseDTO(
            c.getId(),
            c.getNome(),
            c.getCor(),
            c.getDataCadastro(),
            c.getDataAlteracao()
        );
    }
}

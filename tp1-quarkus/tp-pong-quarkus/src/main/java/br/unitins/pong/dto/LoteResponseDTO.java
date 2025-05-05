package br.unitins.pong.dto;

import java.time.LocalDateTime;

import br.unitins.pong.model.Lote;

public record LoteResponseDTO(
    Long id,
    String descricao,
    LocalDateTime dataCadastro,
    LocalDateTime dataAlteracao
) {
    public static LoteResponseDTO valueOf(Lote lote) {
        return new LoteResponseDTO(
            lote.getId(),
            lote.getDescricao(),
            lote.getDataCadastro(),
            lote.getDataAlteracao()
        );
    }
}

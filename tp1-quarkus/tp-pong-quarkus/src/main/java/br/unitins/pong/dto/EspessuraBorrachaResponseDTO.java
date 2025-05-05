package br.unitins.pong.dto;

import java.time.LocalDateTime;

import br.unitins.pong.model.EspessuraBorracha;

public record EspessuraBorrachaResponseDTO(
    Long id,
    Double espessura,
    LocalDateTime dataCadastro,
    LocalDateTime dataAlteracao
) {
    public static EspessuraBorrachaResponseDTO valueOf(EspessuraBorracha e) {
        return new EspessuraBorrachaResponseDTO(
            e.getId(),
            e.getEspessura(),
            e.getDataCadastro(),
            e.getDataAlteracao()
        );
    }
}

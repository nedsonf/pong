package br.unitins.pong.dto;

import jakarta.validation.constraints.NotBlank;

public record LoteDTO(
    @NotBlank String descricao
) {}

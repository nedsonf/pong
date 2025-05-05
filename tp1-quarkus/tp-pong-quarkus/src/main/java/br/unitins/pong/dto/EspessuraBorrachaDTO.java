package br.unitins.pong.dto;

import jakarta.validation.constraints.NotNull;

public record EspessuraBorrachaDTO(
    @NotNull Double espessura
) {}

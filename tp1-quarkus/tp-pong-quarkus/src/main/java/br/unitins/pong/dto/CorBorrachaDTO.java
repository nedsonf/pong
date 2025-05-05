package br.unitins.pong.dto;

import jakarta.validation.constraints.NotBlank;

public record CorBorrachaDTO(
    @NotBlank String nome,
    @NotBlank String cor
) {}

package br.unitins.pong.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RaqueteDTO(
    @NotBlank String nome,
    @NotNull Double preco,
    @NotNull Integer estoqueDisponivel,
    @NotBlank String tipo,
    @NotNull Long idFabricante,
    @NotNull Long idCorBorracha,
    @NotNull Long idEspessuraBorracha,
    @NotNull Long idLote
) {}

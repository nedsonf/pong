package br.unitins.tp1.pong.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO (
    String nome,
    String cep,
    String codigo,
    String rua,
    String bairro,
    String numeroLote,
    String complemento,
    @NotBlank(message = "O campo cidade não pode ser nulo")
    Long cidade
) {
    
}

package br.unitins.pong.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteDTO(
    @NotBlank String nome,
    @NotBlank @Email String email,
    @NotBlank String cpf,
    @NotBlank String cep,
    String endereco,
    @NotBlank String senha
) {}

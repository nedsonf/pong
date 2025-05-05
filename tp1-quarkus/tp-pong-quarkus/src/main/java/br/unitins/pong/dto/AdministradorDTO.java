package br.unitins.pong.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AdministradorDTO(
    @NotBlank String nome,
    @NotBlank @Email String email,
    @NotBlank String senha,
     String idFuncionario
) {}

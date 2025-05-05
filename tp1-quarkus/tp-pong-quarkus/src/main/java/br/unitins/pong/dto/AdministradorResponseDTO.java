package br.unitins.pong.dto;

import java.time.LocalDateTime;

import br.unitins.pong.model.Administrador;

public record AdministradorResponseDTO(
    Long id,
    String nome,
    String email,
    String idFuncionario,
    LocalDateTime dataCadastro,
    LocalDateTime dataAlteracao
) {
    public static AdministradorResponseDTO valueOf(Administrador adm) {
        return new AdministradorResponseDTO(
            adm.getId(),
            adm.getNome(),
            adm.getEmail(),
            adm.getIdFuncionario(),
            adm.getDataCadastro(),
            adm.getDataAlteracao()
        );
    }
}

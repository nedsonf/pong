package br.unitins.pong.dto;

import java.time.LocalDateTime;
import br.unitins.pong.model.Cliente;

public record ClienteResponseDTO(
    Long id,
    String nome,
    String email,
    String cpf,
    String cep,
    String endereco,
    LocalDateTime dataCadastro,
    LocalDateTime dataAlteracao
) {
    public static ClienteResponseDTO valueOf(Cliente c) {
        return new ClienteResponseDTO(
            c.getId(),
            c.getNome(),
            c.getEmail(),
            c.getCpf(),
            c.getCep(),
            c.getEndereco(),
            c.getDataCadastro(),
            c.getDataAlteracao()
        );
    }
}

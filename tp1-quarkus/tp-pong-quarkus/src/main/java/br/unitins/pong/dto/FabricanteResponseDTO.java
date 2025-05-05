package br.unitins.pong.dto;

import java.time.LocalDateTime;
import br.unitins.pong.model.Fabricante;

public record FabricanteResponseDTO(
    Long id,
    String nome,
    String email,
    String cnpj,
    LocalDateTime dataCadastro,
    LocalDateTime dataAlteracao
) {
    public static FabricanteResponseDTO valueOf(Fabricante f) {
        return new FabricanteResponseDTO(
            f.getId(),
            f.getNome(),
            f.getEmail(),
            f.getCnpj(),
            f.getDataCadastro(),
            f.getDataAlteracao()
        );
    }
}

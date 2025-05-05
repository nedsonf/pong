package br.unitins.pong.dto;

import java.time.LocalDateTime;

import br.unitins.pong.model.Raquete;

public record RaqueteResponseDTO(
    Long id,
    String nome,
    Double preco,
    Integer estoqueDisponivel,
    String tipo,
    String nomeFabricante,
    String corBorracha,
    Double espessuraBorracha,
    Long idLote,
    LocalDateTime dataCadastro,
    LocalDateTime dataAlteracao
) {
    public static RaqueteResponseDTO valueOf(Raquete r) {
        return new RaqueteResponseDTO(
            r.getId(),
            r.getNome(),
            r.getPreco(),
            r.getEstoqueDisponivel(),
            r.getTipo().getLabel(),
            r.getFabricante().getNome(),
            r.getCorBorracha().getNome(),
            r.getEspessuraBorracha().getEspessura(),
            r.getLote().getId(),
            r.getDataCadastro(),
            r.getDataAlteracao()
        );
    }
}

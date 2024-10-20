package br.unitins.tp1.pong.dto;

import br.unitins.tp1.pong.model.Cidade;
import br.unitins.tp1.pong.model.Endereco;

public record EnderecoResponseDTO(
    Long id,
    String nome,
    String cep,
    String codigo,
    String rua,
    String bairro,
    String numeroLote,
    String complemento,
    Cidade cidade
) {
    public static EnderecoResponseDTO valueOf(Endereco endereco) {
        return new EnderecoResponseDTO(
            endereco.getId(),
            endereco.getNome(),
            endereco.getCep(),
            endereco.getCodigo(),
            endereco.getRua(),
            endereco.getBairro(),
            endereco.getNumeroLote(),
            endereco.getComplemento(),
            endereco.getCidade());
    }
}

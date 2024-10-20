package br.unitins.tp1.pong.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.time.LocalDateTime;

public record RaqueteDTO (
  @NotBlank(message = "O campo NomeRaquete não pode ser nulo")
  String NomeRaquete,
  ,
  @Size(max = 400, message = "O campo descricao deve ter no máximo 400 caracteres")
  String descricao,
  String codigo,
  // String imagemPrincipal,
  // String[] imagens,
  @NotNull(message = "O campo precoVenda não pode ser nulo")
  Double precoVenda,
  @NotNull(message = "O campo precoCusto não pode ser nulo")
  Double precoCusto,
  @NotNull(message = "O campo desconto não pode ser nulo")
  Double desconto,
  @NotNull(message = "O campo quantidadeDisponivel não pode ser nulo")
  @Min(value = 0, message = "O campo quantidadeDisponivel deve ser maior ou igual a 0")
  Integer quantidadeDisponivel,
  // @NotNull(message = "O campo quantidadeVendido não pode ser nulo")
  // Integer quantidadeVendido,
  LocalDateTime dataDisponivel,
  String nacionalidade,
  String TempoDesgaste,
  @NotNull(message = "O campo statusRaquete não pode ser nulo")
  Integer idStatusRaquete,
  @NotNull(message = "O campo exeperienciaExigida não pode ser nulo")
  Integer exeperienciaExigida,
  List<Long> idsTags,
  @NotNull(message = "O campo id não pode ser nulo")
  Long id,
  @NotNull(message = "O campo idCategoriaBiologica não pode ser nulo")
  Long idCategoriaBiologica
) {

}

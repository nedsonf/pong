package br.unitins.tp1.pong.service;

import java.util.List;

import br.unitins.tp1.pong.dto.EstadoDTO;
import br.unitins.tp1.pong.dto.EstadoResponseDTO;

public interface EstadoService {
  
  public EstadoResponseDTO insert(EstadoDTO dto);

  public EstadoResponseDTO update(EstadoDTO dto, Long id);

  public void delete(Long id);

  public List<EstadoResponseDTO> findAll();

  public EstadoResponseDTO findById(Long id);

  public List<EstadoResponseDTO> findByNome(String nome);
  
  public List<EstadoResponseDTO> findBySigla(String sigla);
  
  public List<EstadoResponseDTO> findByNomeESigla(String txt);

}

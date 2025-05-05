package br.unitins.pong.service;

import java.util.List;

import br.unitins.pong.dto.FabricanteDTO;
import br.unitins.pong.dto.FabricanteResponseDTO;

public interface FabricanteService {

    FabricanteResponseDTO create(FabricanteDTO dto);

    FabricanteResponseDTO findById(Long id);

    List<FabricanteResponseDTO> findAll();

    FabricanteResponseDTO update(Long id, FabricanteDTO dto);

    void delete(Long id);
}

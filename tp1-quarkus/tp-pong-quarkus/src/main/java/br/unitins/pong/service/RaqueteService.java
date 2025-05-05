package br.unitins.pong.service;

import java.util.List;

import br.unitins.pong.dto.RaqueteDTO;
import br.unitins.pong.dto.RaqueteResponseDTO;

public interface RaqueteService {

    RaqueteResponseDTO create(RaqueteDTO dto);

    RaqueteResponseDTO findById(Long id);

    List<RaqueteResponseDTO> findAll();

    RaqueteResponseDTO update(Long id, RaqueteDTO dto);

    void delete(Long id);
}

package br.unitins.pong.service;

import java.util.List;

import br.unitins.pong.dto.CorBorrachaDTO;
import br.unitins.pong.dto.CorBorrachaResponseDTO;

public interface CorBorrachaService {

    CorBorrachaResponseDTO create(CorBorrachaDTO dto);

    CorBorrachaResponseDTO findById(Long id);

    List<CorBorrachaResponseDTO> findAll();

    CorBorrachaResponseDTO update(Long id, CorBorrachaDTO dto);

    void delete(Long id);
}

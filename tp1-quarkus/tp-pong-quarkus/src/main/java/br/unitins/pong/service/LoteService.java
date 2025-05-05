package br.unitins.pong.service;

import java.util.List;

import br.unitins.pong.dto.LoteDTO;
import br.unitins.pong.dto.LoteResponseDTO;

public interface LoteService {

    LoteResponseDTO create(LoteDTO dto);

    LoteResponseDTO findById(Long id);

    List<LoteResponseDTO> findAll();

    LoteResponseDTO update(Long id, LoteDTO dto);

    void delete(Long id);
}

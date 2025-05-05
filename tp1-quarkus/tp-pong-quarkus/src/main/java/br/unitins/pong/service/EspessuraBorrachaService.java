package br.unitins.pong.service;

import java.util.List;

import br.unitins.pong.dto.EspessuraBorrachaDTO;
import br.unitins.pong.dto.EspessuraBorrachaResponseDTO;

public interface EspessuraBorrachaService {

    EspessuraBorrachaResponseDTO create(EspessuraBorrachaDTO dto);

    EspessuraBorrachaResponseDTO findById(Long id);

    List<EspessuraBorrachaResponseDTO> findAll();

    EspessuraBorrachaResponseDTO update(Long id, EspessuraBorrachaDTO dto);

    void delete(Long id);
}

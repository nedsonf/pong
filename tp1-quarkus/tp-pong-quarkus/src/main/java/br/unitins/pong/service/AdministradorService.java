package br.unitins.pong.service;

import java.util.List;

import br.unitins.pong.dto.AdministradorDTO;
import br.unitins.pong.dto.AdministradorResponseDTO;

public interface AdministradorService {

    AdministradorResponseDTO create(AdministradorDTO dto);

    AdministradorResponseDTO findById(Long id);

    List<AdministradorResponseDTO> findAll();

    AdministradorResponseDTO update(Long id, AdministradorDTO dto);

    void delete(Long id);
}

package br.unitins.pong.service;

import java.util.List;

import br.unitins.pong.dto.ClienteDTO;
import br.unitins.pong.dto.ClienteResponseDTO;

public interface ClienteService {

    ClienteResponseDTO create(ClienteDTO dto);

    ClienteResponseDTO findById(Long id);

    List<ClienteResponseDTO> findAll();

    ClienteResponseDTO update(Long id, ClienteDTO dto);

    void delete(Long id);
}

package br.unitins.pong.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.pong.dto.ClienteDTO;
import br.unitins.pong.dto.ClienteResponseDTO;
import br.unitins.pong.exception.NotFoundException;
import br.unitins.pong.model.Cliente;
import br.unitins.pong.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    ClienteRepository repository;

    @Override
    @Transactional
    public ClienteResponseDTO create(ClienteDTO dto) {
        Cliente c = new Cliente();
        c.setNome(dto.nome());
        c.setEmail(dto.email());
        c.setCpf(dto.cpf());
        c.setCep(dto.cep());
        c.setEndereco(dto.endereco());
        c.setSenha(dto.senha());
        repository.persist(c);
        return ClienteResponseDTO.valueOf(c);
    }

    @Override
    public List<ClienteResponseDTO> findAll() {
        return repository.listAll()
                .stream()
                .map(ClienteResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        Cliente c = repository.findById(id);
        if (c == null)
            throw new NotFoundException("Cliente não encontrado.");
        return ClienteResponseDTO.valueOf(c);
    }

    @Override
    @Transactional
    public ClienteResponseDTO update(Long id, ClienteDTO dto) {
        Cliente c = repository.findById(id);
        if (c == null)
            throw new NotFoundException("Cliente não encontrado.");
        c.setNome(dto.nome());
        c.setEmail(dto.email());
        c.setCpf(dto.cpf());
        c.setCep(dto.cep());
        c.setEndereco(dto.endereco());
        c.setSenha(dto.senha());
        return ClienteResponseDTO.valueOf(c);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException("Cliente não encontrado.");
    }
}

package br.unitins.pong.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.pong.dto.CorBorrachaDTO;
import br.unitins.pong.dto.CorBorrachaResponseDTO;
import br.unitins.pong.exception.NotFoundException;
import br.unitins.pong.model.CorBorracha;
import br.unitins.pong.repository.CorBorrachaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CorBorrachaServiceImpl implements CorBorrachaService {

    @Inject
    CorBorrachaRepository repository;

    @Override
    @Transactional
    public CorBorrachaResponseDTO create(CorBorrachaDTO dto) {
        CorBorracha c = new CorBorracha();
        c.setNome(dto.nome());
        c.setCor(dto.cor());
        repository.persist(c);
        return CorBorrachaResponseDTO.valueOf(c);
    }

    @Override
    public List<CorBorrachaResponseDTO> findAll() {
        return repository.listAll().stream()
            .map(CorBorrachaResponseDTO::valueOf)
            .collect(Collectors.toList());
    }

    @Override
    public CorBorrachaResponseDTO findById(Long id) {
        CorBorracha c = repository.findById(id);
        if (c == null)
            throw new NotFoundException("Cor da borracha não encontrada.");
        return CorBorrachaResponseDTO.valueOf(c);
    }

    @Override
    @Transactional
    public CorBorrachaResponseDTO update(Long id, CorBorrachaDTO dto) {
        CorBorracha c = repository.findById(id);
        if (c == null)
            throw new NotFoundException("Cor da borracha não encontrada.");
        c.setNome(dto.nome());
        c.setCor(dto.cor());
        return CorBorrachaResponseDTO.valueOf(c);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException("Cor da borracha não encontrada.");
    }
}

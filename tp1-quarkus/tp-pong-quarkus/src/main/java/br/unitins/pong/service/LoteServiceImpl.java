package br.unitins.pong.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.pong.dto.LoteDTO;
import br.unitins.pong.dto.LoteResponseDTO;
import br.unitins.pong.exception.NotFoundException;
import br.unitins.pong.model.Lote;
import br.unitins.pong.repository.LoteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class LoteServiceImpl implements LoteService {

    @Inject
    LoteRepository repository;

    @Override
    @Transactional
    public LoteResponseDTO create(LoteDTO dto) {
        Lote lote = new Lote();
        lote.setDescricao(dto.descricao());
        repository.persist(lote);
        return LoteResponseDTO.valueOf(lote);
    }

    @Override
    public List<LoteResponseDTO> findAll() {
        return repository.listAll().stream()
                .map(LoteResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public LoteResponseDTO findById(Long id) {
        Lote lote = repository.findById(id);
        if (lote == null)
            throw new NotFoundException("Lote não encontrado.");
        return LoteResponseDTO.valueOf(lote);
    }

    @Override
    @Transactional
    public LoteResponseDTO update(Long id, LoteDTO dto) {
        Lote lote = repository.findById(id);
        if (lote == null)
            throw new NotFoundException("Lote não encontrado.");
        lote.setDescricao(dto.descricao());
        return LoteResponseDTO.valueOf(lote);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException("Lote não encontrado.");
    }
}

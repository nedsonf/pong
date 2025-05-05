package br.unitins.pong.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.pong.dto.FabricanteDTO;
import br.unitins.pong.dto.FabricanteResponseDTO;
import br.unitins.pong.exception.NotFoundException;
import br.unitins.pong.model.Fabricante;
import br.unitins.pong.repository.FabricanteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FabricanteServiceImpl implements FabricanteService {

    @Inject
    FabricanteRepository repository;

    @Override
    @Transactional
    public FabricanteResponseDTO create(FabricanteDTO dto) {
        Fabricante f = new Fabricante();
        f.setNome(dto.nome());
        f.setEmail(dto.email());
        f.setCnpj(dto.cnpj());
        repository.persist(f);
        return FabricanteResponseDTO.valueOf(f);
    }

    @Override
    public List<FabricanteResponseDTO> findAll() {
        return repository.listAll()
                .stream()
                .map(FabricanteResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public FabricanteResponseDTO findById(Long id) {
        Fabricante f = repository.findById(id);
        if (f == null)
            throw new NotFoundException("Fabricante não encontrado.");
        return FabricanteResponseDTO.valueOf(f);
    }

    @Override
    @Transactional
    public FabricanteResponseDTO update(Long id, FabricanteDTO dto) {
        Fabricante f = repository.findById(id);
        if (f == null)
            throw new NotFoundException("Fabricante não encontrado.");
        f.setNome(dto.nome());
        f.setEmail(dto.email());
        f.setCnpj(dto.cnpj());
        return FabricanteResponseDTO.valueOf(f);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException("Fabricante não encontrado.");
    }
}

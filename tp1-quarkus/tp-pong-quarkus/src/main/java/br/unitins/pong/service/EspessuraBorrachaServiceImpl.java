package br.unitins.pong.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.pong.dto.EspessuraBorrachaDTO;
import br.unitins.pong.dto.EspessuraBorrachaResponseDTO;
import br.unitins.pong.exception.NotFoundException;
import br.unitins.pong.model.EspessuraBorracha;
import br.unitins.pong.repository.EspessuraBorrachaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EspessuraBorrachaServiceImpl implements EspessuraBorrachaService {

    @Inject
    EspessuraBorrachaRepository repository;

    @Override
    @Transactional
    public EspessuraBorrachaResponseDTO create(EspessuraBorrachaDTO dto) {
        EspessuraBorracha e = new EspessuraBorracha();
        e.setEspessura(dto.espessura());
        repository.persist(e);
        return EspessuraBorrachaResponseDTO.valueOf(e);
    }

    @Override
    public List<EspessuraBorrachaResponseDTO> findAll() {
        return repository.listAll().stream()
            .map(EspessuraBorrachaResponseDTO::valueOf)
            .collect(Collectors.toList());
    }

    @Override
    public EspessuraBorrachaResponseDTO findById(Long id) {
        EspessuraBorracha e = repository.findById(id);
        if (e == null)
            throw new NotFoundException("Espessura da borracha não encontrada.");
        return EspessuraBorrachaResponseDTO.valueOf(e);
    }

    @Override
    @Transactional
    public EspessuraBorrachaResponseDTO update(Long id, EspessuraBorrachaDTO dto) {
        EspessuraBorracha e = repository.findById(id);
        if (e == null)
            throw new NotFoundException("Espessura da borracha não encontrada.");
        e.setEspessura(dto.espessura());
        return EspessuraBorrachaResponseDTO.valueOf(e);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException("Espessura da borracha não encontrada.");
    }
}

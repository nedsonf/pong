package br.unitins.pong.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.pong.dto.AdministradorDTO;
import br.unitins.pong.dto.AdministradorResponseDTO;
import br.unitins.pong.exception.NotFoundException;
import br.unitins.pong.model.Administrador;
import br.unitins.pong.repository.AdministradorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AdministradorServiceImpl implements AdministradorService {

    @Inject
    AdministradorRepository repository;

    @Override
    @Transactional
    public AdministradorResponseDTO create(AdministradorDTO dto) {
        Administrador adm = new Administrador();
        adm.setNome(dto.nome());
        adm.setEmail(dto.email());
        adm.setSenha(dto.senha());
        adm.setIdFuncionario(dto.idFuncionario());
        repository.persist(adm);
        return AdministradorResponseDTO.valueOf(adm);
    }

    @Override
    public List<AdministradorResponseDTO> findAll() {
        return repository.listAll().stream()
                .map(AdministradorResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public AdministradorResponseDTO findById(Long id) {
        Administrador adm = repository.findById(id);
        if (adm == null)
            throw new NotFoundException("Administrador não encontrado.");
        return AdministradorResponseDTO.valueOf(adm);
    }

    @Override
    @Transactional
    public AdministradorResponseDTO update(Long id, AdministradorDTO dto) {
        Administrador adm = repository.findById(id);
        if (adm == null)
            throw new NotFoundException("Administrador não encontrado.");
        adm.setNome(dto.nome());
        adm.setEmail(dto.email());
        adm.setSenha(dto.senha());
        adm.setIdFuncionario(dto.idFuncionario());
        return AdministradorResponseDTO.valueOf(adm);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException("Administrador não encontrado.");
    }
}

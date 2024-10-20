package br.unitins.tp1.pong.service;

import java.util.List;

import br.unitins.tp1.pong.dto.CidadeDTO;
import br.unitins.tp1.pong.dto.CidadeResponseDTO;
import br.unitins.tp1.pong.model.Cidade;
import br.unitins.tp1.pong.model.Estado;
import br.unitins.tp1.pong.repository.CidadeRepository;
import br.unitins.tp1.pong.repository.EstadoRepository;
import br.unitins.tp1.pong.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CidadeServiceImpl implements CidadeService{
    
    @Inject
    CidadeRepository repository;
    @Inject
    EstadoRepository repositoryEstado;

    @Override
    @Transactional
    public CidadeResponseDTO insert(@Valid CidadeDTO dto) throws Exception {
        
        Estado estado = repositoryEstado.findById(dto.estado());

        if (estado == null) {
            throw new ValidationException("estado", "O estado informado não foi encontrada");
        }

        Cidade novoCidade = new Cidade();
        novoCidade.setNome(dto.nome());
        novoCidade.setEstado(estado);
        novoCidade.setFrete(dto.frete());

        repository.persist(novoCidade);

        return CidadeResponseDTO.valueOf(novoCidade);
    }

    @Override
    @Transactional
    public CidadeResponseDTO update(CidadeDTO dto, Long id) throws Exception {

        Estado estado = repositoryEstado.findById(dto.estado());

        if (estado == null) {
            throw new Exception("O estado informado não foi encontrada");
        }
      
        Cidade cidade = repository.findById(id);
        if (cidade != null) {
            cidade.setNome(dto.nome());
            cidade.setEstado(estado);
            cidade.setFrete(dto.frete());
        } else {
            throw new NotFoundException();
        }
        return CidadeResponseDTO.valueOf(cidade);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id)) 
            throw new NotFoundException();
    }

    @Override
    public CidadeResponseDTO findById(Long id) {
        return CidadeResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<CidadeResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
            .map(e -> CidadeResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<CidadeResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(e -> CidadeResponseDTO.valueOf(e)).toList();
    }
}

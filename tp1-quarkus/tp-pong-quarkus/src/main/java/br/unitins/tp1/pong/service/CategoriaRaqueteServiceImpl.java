package br.unitins.tp1.pong.service;

import java.util.List;

import br.unitins.tp1.pong.dto.CategoriaRaqueteDTO;
import br.unitins.tp1.pong.dto.CategoriaRaqueteRespondeDTO;
import br.unitins.tp1.pong.dto.CategoriaRaqueteUpdateAtivaDTO;
import br.unitins.tp1.pong.model.CategoriaRaquete;
import br.unitins.tp1.pong.model.TipoCategoria;
import br.unitins.tp1.pong.repository.CategoriaRaqueteRepository;
import br.unitins.tp1.pong.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CategoriaRaqueteServiceImpl implements CategoriaRaqueteService {

  @Inject
  CategoriaRaqueteRepository repository;
  // @Inject
  // TipoProdutoRepository repositoryTipoProduto;

  @Override
  @Transactional
  public CategoriaRaqueteRespondeDTO insert(CategoriaRaqueteDTO dto) {
    CategoriaRaquete novaCategoriaRaquete = new CategoriaRaquete();

    TipoCategoria tipoCategoria = TipoCategoria.valueOf(dto.idTipoCategoria());
    if (tipoCategoria == null) {
      throw new ValidationException("tipoCategoria", "Id para tipo categoria inválido.");
    }

    if (repository.findByNome(dto.nome(), true).count() > 0) {
      throw new ValidationException("nome", "Nome já cadastrado.");
    }

    novaCategoriaRaquete.setNome(dto.nome());
    novaCategoriaRaquete.setDescricao(dto.descricao());
    novaCategoriaRaquete.setPrioridade(dto.prioridade());
    novaCategoriaRaquete.setAtiva(dto.ativa());
    novaCategoriaRaquete.setTipoCategoria(tipoCategoria);


    repository.persist(novaCategoriaRaquete);
    
    return CategoriaRaqueteRespondeDTO.valueOf(novaCategoriaRaquete);
  }

  @Override
  @Transactional
  public CategoriaRaqueteRespondeDTO update(CategoriaRaqueteDTO dto, Long id) {
    CategoriaRaquete categoriaRaquete = repository.findById(id);

    if (categoriaRaquete == null) {
      throw new NotFoundException();
    }

    TipoCategoria tipoCategoria = TipoCategoria.valueOf(dto.idTipoCategoria());
    if (tipoCategoria == null) {
      throw new ValidationException("tipoCategoria", "Id para tipo categoria inválido.");
    }

    if (!categoriaRaquete.getNome().equals(dto.nome()) && repository.findByNome(dto.nome(), true).count() > 0) {
      throw new ValidationException("nome", "Nome já cadastrado.");
    }

    categoriaRaquete.setNome(dto.nome());
    categoriaRaquete.setDescricao(dto.descricao());
    categoriaRaquete.setPrioridade(dto.prioridade());
    categoriaRaquete.setAtiva(dto.ativa());
    categoriaRaquete.setTipoCategoria(tipoCategoria);

    return CategoriaRaqueteRespondeDTO.valueOf(categoriaRaquete);
  }

  @Override
  @Transactional
  public void updateAtiva(CategoriaRaqueteUpdateAtivaDTO dto, Long id) {
    CategoriaRaquete categoriaRaquete = repository.findById(id);

    if (categoriaRaquete == null) {
      throw new NotFoundException();
    }

    categoriaRaquete.setAtiva(dto.ativa());
  }

  @Override
  @Transactional
  public void delete(Long id) throws Exception {
    CategoriaRaquete categoriaRaquete = repository.findById(id);
    if (categoriaRaquete == null) {
      throw new NotFoundException();
    }

    if (!repository.deleteById(id)) {
      throw new NotFoundException();
    }
  }

  @Override
  public List<CategoriaRaqueteRespondeDTO> findAll() {
    return repository.listAll()
      .stream()
      .map(e -> CategoriaRaqueteRespondeDTO.valueOf(e))
      .toList();
  }

  @Override
  public CategoriaRaqueteRespondeDTO findById(Long id) {
    CategoriaRaquete categoriaRaquete = repository.findById(id);

    if (categoriaRaquete == null) {
      throw new NotFoundException();
    }

    return CategoriaRaqueteRespondeDTO.valueOf(categoriaRaquete);
  }

  @Override
  public List<CategoriaRaqueteRespondeDTO> findByNome(String nome) {
    return repository.findByNome(nome, false)
      .stream()
      .map(e -> CategoriaRaqueteRespondeDTO.valueOf(e))
      .toList();
  }

  @Override
  public List<CategoriaRaqueteRespondeDTO> findByAtiva(Boolean idAtiva) {
    return repository.findByAtiva(idAtiva)
      .stream()
      .map(e -> CategoriaRaqueteRespondeDTO.valueOf(e))
      .toList();
  }

  @Override
  public List<CategoriaRaqueteRespondeDTO> findByTipoCategoria(Integer idTipoCategoria) {
    
    TipoCategoria tipoCategoria = TipoCategoria.valueOf(idTipoCategoria);
    if (tipoCategoria == null) {
      throw new NotFoundException("Id para tipo categoria inválido.");
    }

    return repository.findByTipoCategoria(tipoCategoria)
      .stream()
      .map(e -> CategoriaRaqueteRespondeDTO.valueOf(e))
      .toList();
  }
}

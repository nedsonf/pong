package br.unitins.tp1.pong.service;

import java.util.List;

import br.unitins.tp1.pong.dto.CategoriaRaqueteDTO;
import br.unitins.tp1.pong.dto.CategoriaRaqueteRespondeDTO;
import br.unitins.tp1.pong.dto.CategoriaRaqueteUpdateAtivaDTO;

public interface CategoriaRaqueteService {
  
  public CategoriaRaqueteRespondeDTO insert(CategoriaRaqueteDTO dto);

  public CategoriaRaqueteRespondeDTO update(CategoriaRaqueteDTO dto, Long id);

  public void updateAtiva(CategoriaRaqueteUpdateAtivaDTO dto, Long id);

  public void delete(Long id) throws Exception;

  public List<CategoriaRaqueteRespondeDTO> findAll();

  public CategoriaRaqueteRespondeDTO findById(Long id);

  public List<CategoriaRaqueteRespondeDTO> findByNome(String nome);

  public List<CategoriaRaqueteRespondeDTO> findByAtiva(Boolean idAtiva);

  public List<CategoriaRaqueteRespondeDTO> findByTipoCategoria(Integer idTipoCategoria);

}

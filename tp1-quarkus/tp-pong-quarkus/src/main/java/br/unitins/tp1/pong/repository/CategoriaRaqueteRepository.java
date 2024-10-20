package br.unitins.tp1.pong.repository;

import java.util.List;

import br.unitins.tp1.pong.model.CategoriaRaquete;
import br.unitins.tp1.pong.model.TipoCategoria;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriaRaqueteRepository implements PanacheRepository<CategoriaRaquete> {
  public PanacheQuery<CategoriaRaquete> findByNome(String nome, boolean caseSensitive) {
    if (nome == null) {
      return null;
    }
    if (caseSensitive) {
      return find("nome", nome);
    } else {
      return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome + "%");
    }
  }

  public List<CategoriaRaquete> findByAtiva(boolean ativa) {
    return find("ativa", ativa).list();
  }

  public List<CategoriaRaquete> findByPrioridade() {
    return find("order by prioridade asc").list();
  }

   public List<CategoriaRaquete> findByTipoCategoria(TipoCategoria tipoCategoria) {
    return find("tipoCategoria = ?1", tipoCategoria).list();
  }


}

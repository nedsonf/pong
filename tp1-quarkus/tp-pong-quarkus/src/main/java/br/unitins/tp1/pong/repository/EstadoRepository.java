package br.unitins.tp1.pong.repository;

import java.util.List;

import br.unitins.tp1.pong.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado> {
  public List<Estado> findByNome(String nome) {
    return find("UPPER(nome) LIKE UPPER(?1) ", "%"+nome+"%").list();
  }

  public List<Estado> findBySigla(String sigla) {
    return find("UPPER(sigla) LIKE UPPER(?1) ", "%"+sigla+"%").list();
  }
}

package br.unitins.pong.repository;

import br.unitins.pong.model.Fabricante;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FabricanteRepository implements PanacheRepository<Fabricante> {

    public Fabricante findByCnpj(String cnpj) {
        return find("cnpj = ?1", cnpj).firstResult();
    }
}

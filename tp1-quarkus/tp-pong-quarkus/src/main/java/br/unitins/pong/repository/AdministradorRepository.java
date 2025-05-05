package br.unitins.pong.repository;

import br.unitins.pong.model.Administrador;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdministradorRepository implements PanacheRepository<Administrador> {

    public Administrador findByEmail(String email) {
        return find("email = ?1", email).firstResult();
    }
}

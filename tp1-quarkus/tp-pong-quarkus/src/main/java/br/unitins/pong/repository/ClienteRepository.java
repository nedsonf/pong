package br.unitins.pong.repository;

import br.unitins.pong.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public Cliente findByCpf(String cpf) {
        return find("cpf = ?1", cpf).firstResult();
    }

    public Cliente findByEmail(String email) {
        return find("email = ?1", email).firstResult();
    }
}

package br.unitins.pong.repository;

import br.unitins.pong.model.CorBorracha;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CorBorrachaRepository implements PanacheRepository<CorBorracha> {}

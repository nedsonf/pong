package br.unitins.pong.repository;

import br.unitins.pong.model.EspessuraBorracha;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EspessuraBorrachaRepository implements PanacheRepository<EspessuraBorracha> {}

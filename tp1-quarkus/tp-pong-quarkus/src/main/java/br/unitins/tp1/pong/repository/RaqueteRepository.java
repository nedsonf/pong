package br.unitins.tp1.pong.repository;

import java.util.List;

import br.unitins.tp1.pong.model.Raquete;
import br.unitins.tp1.pong.model.StatusRaquete;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.LockModeType;
import jakarta.persistence.NoResultException;

@ApplicationScoped
public class RaqueteRepository implements PanacheRepository<Raquete>{
    public List<Raquete> findByNome(String nome) {
        if (nome == null) {
            return null;
          }
        return find("LOWER(NomeRaquete) LIKE LOWER(?1) OR LOWER(nomeCientifico) LIKE LOWER(?1)", "%" + nome + "%").list();
    }

    public Raquete findByCodigo(String codigo) {
        try {
            return find("codigo = ?1 ", codigo ).singleResult();
        } catch (NoResultException e) {
            return null;
        } 
    }

    public Raquete findByIdComBloqueioCompartilhado(Long id) {
        PanacheQuery<Raquete> query = find("id = ?1", id);
        query.withLock(LockModeType.PESSIMISTIC_READ);

        try {
            return query.singleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Raquete> findBy(Long id) {
        return find(".id = ?1", id).list();
    }

    public List<Raquete> findByStatusRaquete(StatusRaquete statusRaquete) {
        return find("statusRaquete = ?1", statusRaquete).list();
    }

    public List<Raquete> findByexeperienciaExigida(Long id){
        return find("exeperienciaExigida = ?1", id).list();
    }

    public List<Raquete> findByEspessuraBorracha(Long id){
        return find("EspessuraBorracha = ?1", id).list();
    }

    public List<Raquete> findBy(String porte) {

        return find("porte = ?1", porte).list();
    }

    public List<Raquete> findByCategoriaRaquete(Long id){
        return find("categoriaRaquete = ?1", id).list();
    }

    public List<Raquete> findByTag(Long id){
        return find("SELECT p FROM Raquete p JOIN p.tag tp WHERE tp.id = ?1", id).list();
    }
}

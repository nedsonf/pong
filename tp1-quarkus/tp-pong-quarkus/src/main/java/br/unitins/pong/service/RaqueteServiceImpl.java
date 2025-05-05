package br.unitins.pong.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.pong.dto.RaqueteDTO;
import br.unitins.pong.dto.RaqueteResponseDTO;
import br.unitins.pong.exception.NotFoundException;
import br.unitins.pong.model.*;
import br.unitins.pong.repository.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RaqueteServiceImpl implements RaqueteService {

    @Inject
    RaqueteRepository raqueteRepo;

    @Inject
    FabricanteRepository fabricanteRepo;

    @Inject
    CorBorrachaRepository corRepo;

    @Inject
    EspessuraBorrachaRepository espessuraRepo;

    @Inject
    LoteRepository loteRepo;

    @Override
    @Transactional
    public RaqueteResponseDTO create(RaqueteDTO dto) {
        Raquete r = new Raquete();
        r.setNome(dto.nome());
        r.setPreco(dto.preco());
        r.setEstoqueDisponivel(dto.estoqueDisponivel());
        r.setTipo(TiposRaquete.valueOf(dto.tipo()));
        r.setFabricante(getFabricante(dto.idFabricante()));
        r.setCorBorracha(getCor(dto.idCorBorracha()));
        r.setEspessuraBorracha(getEspessura(dto.idEspessuraBorracha()));
        r.setLote(getLote(dto.idLote()));
        raqueteRepo.persist(r);
        return RaqueteResponseDTO.valueOf(r);
    }

    @Override
    public List<RaqueteResponseDTO> findAll() {
        return raqueteRepo.listAll().stream()
                .map(RaqueteResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public RaqueteResponseDTO findById(Long id) {
        Raquete r = raqueteRepo.findById(id);
        if (r == null)
            throw new NotFoundException("Raquete não encontrada.");
        return RaqueteResponseDTO.valueOf(r);
    }

    @Override
    @Transactional
    public RaqueteResponseDTO update(Long id, RaqueteDTO dto) {
        Raquete r = raqueteRepo.findById(id);
        if (r == null)
            throw new NotFoundException("Raquete não encontrada.");
        r.setNome(dto.nome());
        r.setPreco(dto.preco());
        r.setEstoqueDisponivel(dto.estoqueDisponivel());
        r.setTipo(TiposRaquete.valueOf(dto.tipo()));
        r.setFabricante(getFabricante(dto.idFabricante()));
        r.setCorBorracha(getCor(dto.idCorBorracha()));
        r.setEspessuraBorracha(getEspessura(dto.idEspessuraBorracha()));
        r.setLote(getLote(dto.idLote()));
        return RaqueteResponseDTO.valueOf(r);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!raqueteRepo.deleteById(id))
            throw new NotFoundException("Raquete não encontrada.");
    }

    // Métodos auxiliares

    private Fabricante getFabricante(Long id) {
        Fabricante f = fabricanteRepo.findById(id);
        if (f == null)
            throw new NotFoundException("Fabricante não encontrado.");
        return f;
    }

    private CorBorracha getCor(Long id) {
        CorBorracha c = corRepo.findById(id);
        if (c == null)
            throw new NotFoundException("Cor da borracha não encontrada.");
        return c;
    }

    private EspessuraBorracha getEspessura(Long id) {
        EspessuraBorracha e = espessuraRepo.findById(id);
        if (e == null)
            throw new NotFoundException("Espessura da borracha não encontrada.");
        return e;
    }

    private Lote getLote(Long id) {
        Lote l = loteRepo.findById(id);
        if (l == null)
            throw new NotFoundException("Lote não encontrado.");
        return l;
    }
}

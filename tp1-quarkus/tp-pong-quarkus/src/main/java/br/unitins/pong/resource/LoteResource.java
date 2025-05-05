package br.unitins.pong.resource;

import java.util.List;

import br.unitins.pong.dto.LoteDTO;
import br.unitins.pong.dto.LoteResponseDTO;
import br.unitins.pong.service.LoteServiceImpl;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/lotes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoteResource {

    @Inject
    LoteServiceImpl service;

    @POST
    public LoteResponseDTO create(@Valid LoteDTO dto) {
        return service.create(dto);
    }

    @GET
    public List<LoteResponseDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public LoteResponseDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("/{id}")
    public LoteResponseDTO update(@PathParam("id") Long id, @Valid LoteDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}

package br.unitins.pong.resource;

import java.util.List;

import br.unitins.pong.dto.FabricanteDTO;
import br.unitins.pong.dto.FabricanteResponseDTO;
import br.unitins.pong.service.FabricanteServiceImpl;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/fabricantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FabricanteResource {

    @Inject
    FabricanteServiceImpl service;

    @POST
    public FabricanteResponseDTO create(@Valid FabricanteDTO dto) {
        return service.create(dto);
    }

    @GET
    public List<FabricanteResponseDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public FabricanteResponseDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("/{id}")
    public FabricanteResponseDTO update(@PathParam("id") Long id, @Valid FabricanteDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}

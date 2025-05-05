package br.unitins.pong.resource;

import java.util.List;

import br.unitins.pong.dto.CorBorrachaDTO;
import br.unitins.pong.dto.CorBorrachaResponseDTO;
import br.unitins.pong.service.CorBorrachaServiceImpl;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/cores-borracha")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorBorrachaResource {

    @Inject
    CorBorrachaServiceImpl service;

    @POST
    public CorBorrachaResponseDTO create(@Valid CorBorrachaDTO dto) {
        return service.create(dto);
    }

    @GET
    public List<CorBorrachaResponseDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public CorBorrachaResponseDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("/{id}")
    public CorBorrachaResponseDTO update(@PathParam("id") Long id, @Valid CorBorrachaDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}

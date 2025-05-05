package br.unitins.pong.resource;

import java.util.List;

import br.unitins.pong.dto.EspessuraBorrachaDTO;
import br.unitins.pong.dto.EspessuraBorrachaResponseDTO;
import br.unitins.pong.service.EspessuraBorrachaServiceImpl;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/espessuras-borracha")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EspessuraBorrachaResource {

    @Inject
    EspessuraBorrachaServiceImpl service;

    @POST
    public EspessuraBorrachaResponseDTO create(@Valid EspessuraBorrachaDTO dto) {
        return service.create(dto);
    }

    @GET
    public List<EspessuraBorrachaResponseDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public EspessuraBorrachaResponseDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("/{id}")
    public EspessuraBorrachaResponseDTO update(@PathParam("id") Long id, @Valid EspessuraBorrachaDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}

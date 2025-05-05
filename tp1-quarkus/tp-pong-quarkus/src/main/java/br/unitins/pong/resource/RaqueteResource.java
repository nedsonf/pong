package br.unitins.pong.resource;

import java.util.List;

import br.unitins.pong.dto.RaqueteDTO;
import br.unitins.pong.dto.RaqueteResponseDTO;
import br.unitins.pong.service.RaqueteServiceImpl;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/raquetes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RaqueteResource {

    @Inject
    RaqueteServiceImpl service;

    @POST
    public RaqueteResponseDTO create(@Valid RaqueteDTO dto) {
        return service.create(dto);
    }

    @GET
    public List<RaqueteResponseDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public RaqueteResponseDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("/{id}")
    public RaqueteResponseDTO update(@PathParam("id") Long id, @Valid RaqueteDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}

package br.unitins.pong.resource;

import java.util.List;

import br.unitins.pong.dto.ClienteDTO;
import br.unitins.pong.dto.ClienteResponseDTO;
import br.unitins.pong.service.ClienteServiceImpl;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteServiceImpl service;

    @POST
    public ClienteResponseDTO create(@Valid ClienteDTO dto) {
        return service.create(dto);
    }

    @GET
    public List<ClienteResponseDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public ClienteResponseDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("/{id}")
    public ClienteResponseDTO update(@PathParam("id") Long id, @Valid ClienteDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}

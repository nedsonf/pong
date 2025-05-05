package br.unitins.pong.resource;

import java.util.List;

import br.unitins.pong.dto.AdministradorDTO;
import br.unitins.pong.dto.AdministradorResponseDTO;
import br.unitins.pong.service.AdministradorServiceImpl;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/administradores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdministradorResource {

    @Inject
    AdministradorServiceImpl service;

    @POST
    public AdministradorResponseDTO create(@Valid AdministradorDTO dto) {
        return service.create(dto);
    }

    @GET
    public List<AdministradorResponseDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public AdministradorResponseDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("/{id}")
    public AdministradorResponseDTO update(@PathParam("id") Long id, @Valid AdministradorDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}

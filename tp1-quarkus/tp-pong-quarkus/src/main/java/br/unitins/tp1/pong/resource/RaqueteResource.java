package br.unitins.tp1.pong.resource;

import java.io.File;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.tp1.pong.dto.RaqueteCriarRascunhoDTO;
import br.unitins.tp1.pong.dto.RaqueteDTO;
import br.unitins.tp1.pong.dto.RaqueteUpdateAddRemoveQuantidadeDTO;
import br.unitins.tp1.pong.dto.RaqueteUpdateStatusRaqueteDTO;
import br.unitins.tp1.pong.form.RaqueteImageForm;
import br.unitins.tp1.pong.model.exeperienciaExigida;
import br.unitins.tp1.pong.model.EspessuraBorracha;
import br.unitins.tp1.pong.model.StatusRaquete;
import br.unitins.tp1.pong.model.StatusProduto;
import br.unitins.tp1.pong.model.TipoCategoria;
import br.unitins.tp1.pong.service.RaqueteService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;


@Path("/Raquetes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RaqueteResource {

    @Inject
    RaqueteService service;

    @POST
    public Response criarRascunho(RaqueteCriarRascunhoDTO dto) {
        return Response.status(Status.CREATED).entity(service.criarRascunho(dto)).build();
    }

    // @POST
    // public Response insert(ProdutoDTO dto) {
    //     return Response.status(Status.CREATED).entity(service.insert(dto)).build();
    // }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(RaqueteDTO dto, @PathParam("id") Long id) {
        service.update(dto, id);
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }

    // @RolesAllowed({"Admin"})
    @PATCH
    @Path("/{id}/upload/imagem")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response adicionarImagem(@MultipartForm RaqueteImageForm form, @PathParam("id") Long id) {
        return Response.ok(service.adicionarImagem(form, id)).build();
    }

    // // @RolesAllowed({"Test", "Cliente", "Admin"})
    @GET
    @Path("/{id}/download/imagem/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadImagem(@PathParam("id") Long id, @PathParam("nomeImagem") String nomeImagem){
        File imageFile = service.downloadImagem(nomeImagem ,id);
        ResponseBuilder response = Response.ok(imageFile);
        response.header("Content-Disposition", "attachment;filename=" + imageFile.getName());
        return response.build();
    }

    // @RolesAllowed({"Test", "Cliente", "Admin"})
    @PATCH
    @Path("/{id}/delete/imagem/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response deleteImagem(@PathParam("id") Long id, @PathParam("nomeImagem") String nomeImagem) {
        service.deleteImagem(nomeImagem, id);
        return Response.noContent().build();
    }

    @PATCH
    @Path("/{id}/update/imagemprincipal/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response definirImagemPrincipal(@PathParam("id") Long id, @PathParam("nomeImagem") String nomeImagem) {
        service.definirImagemPrincipal(nomeImagem, id);
        return Response.noContent().build();
    }
    

    // @RolesAllowed({"Test", "Cliente", "Admin"})
    @PATCH
    @Path("/{id}/update/statusRaquete")
    public Response updateStatusRaquete(RaqueteUpdateStatusRaqueteDTO dto, @PathParam("id") Long id) {
        service.updateStatusRaquete(dto, id);
        return Response.noContent().build();
    }

    @PATCH
    @Path("/{id}/update/addremovequantidade")
    public Response updateQuantidade(RaqueteUpdateAddRemoveQuantidadeDTO dto, @PathParam("id") Long id) {
        service.updateAddRemoveQuantidade(dto, id);
        return Response.noContent().build();
    }

    @GET
    @Path("/statusRaquete")
    public Response listAllStatusRaquete() {
        return Response.ok(StatusRaquete.listAll()).build();
    }

    @GET
    @Path("/exeperienciaExigida")
    public Response listAllexeperienciaExigida() {
        return Response.ok(exeperienciaExigida.listAll()).build();
    }

    @GET
    @Path("/espessuraborracha")
    public Response listAllespessuraborracha() {
        return Response.ok(EspessuraBorracha.listAll()).build();
    }

    @GET
    @Path("/")
    public Response listAll() {
        return Response.ok(.listAll()).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    // both NomeRaquete and nomeCientifico
    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(service.findByNome(nome)).build();
    }
    
}

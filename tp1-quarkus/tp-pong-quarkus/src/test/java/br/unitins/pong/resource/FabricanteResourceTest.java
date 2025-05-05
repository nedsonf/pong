package br.unitins.pong.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.jupiter.api.Assertions.assertNull;

import br.unitins.pong.dto.FabricanteDTO;
import br.unitins.pong.dto.FabricanteResponseDTO;
import br.unitins.pong.service.FabricanteService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class FabricanteResourceTest {

    @Inject
    FabricanteService fabricanteService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/fabricantes")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        FabricanteDTO dto = new FabricanteDTO(
            "Stiga",
            "contato@stiga.com",
            "11222333000100"
        );

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when().post("/fabricantes")
            .then()
                .statusCode(200)
                .body(
                    "id", notNullValue(),
                    "nome", is("Stiga"),
                    "email", is("contato@stiga.com"),
                    "cnpj", is("11222333000100")
                );
    }

    @Test
    void testAlterar() {
        FabricanteDTO dto = new FabricanteDTO(
            "Tibhar",
            "contato@tibhar.com",
            "55443322000177"
        );

        id = fabricanteService.create(dto).id();

        FabricanteDTO dtoAlterado = new FabricanteDTO(
            "Tibhar Alterado",
            "suporte@tibhar.com",
            "55443322000199"
        );

        given()
            .contentType(ContentType.JSON)
            .body(dtoAlterado)
            .when().put("/fabricantes/" + id)
            .then()
                .statusCode(200);

        FabricanteResponseDTO response = fabricanteService.findById(id);
        assertThat(response.nome(), is("Tibhar Alterado"));
        assertThat(response.email(), is("suporte@tibhar.com"));
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/fabricantes/" + id)
            .then()
                .statusCode(204);

        try {
            fabricanteService.findById(id);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Fabricante não encontrado."));
        }
    }
}

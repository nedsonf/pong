package br.unitins.pong.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.jupiter.api.Assertions.assertNull;

import br.unitins.pong.dto.RaqueteDTO;
import br.unitins.pong.dto.RaqueteResponseDTO;
import br.unitins.pong.service.RaqueteService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class RaqueteResourceTest {

    @Inject
    RaqueteService raqueteService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/raquetes")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        RaqueteDTO dto = new RaqueteDTO(
            "Raquete Teste",
            250.0,
            12,
            "INVERTIDAS",
            1L,  // idFabricante
            1L,  // idCorBorracha
            1L,  // idEspessuraBorracha
            1L   // idLote
        );

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when().post("/raquetes")
            .then()
                .statusCode(200)
                .body(
                    "id", notNullValue(),
                    "nome", is("Raquete Teste"),
                    "tipo", is("Invertidas")
                );
    }

    @Test
    void testAlterar() {
        RaqueteDTO dto = new RaqueteDTO(
            "Raquete Original",
            300.0,
            8,
            "VELOCIDADE",
            1L,
            1L,
            1L,
            1L
        );

        id = raqueteService.create(dto).id();

        RaqueteDTO dtoAlterado = new RaqueteDTO(
            "Raquete Alterada",
            279.99,
            5,
            "CONTROLE",
            1L,
            1L,
            1L,
            1L
        );

        given()
            .contentType(ContentType.JSON)
            .body(dtoAlterado)
            .when().put("/raquetes/" + id)
            .then()
                .statusCode(200);

        RaqueteResponseDTO response = raqueteService.findById(id);
        assertThat(response.nome(), is("Raquete Alterada"));
        assertThat(response.tipo(), is("Controle"));
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/raquetes/" + id)
            .then()
                .statusCode(204);

        try {
            raqueteService.findById(id);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Raquete não encontrada."));
        }
    }
}

package br.unitins.pong.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import br.unitins.pong.dto.CorBorrachaDTO;
import br.unitins.pong.dto.CorBorrachaResponseDTO;
import br.unitins.pong.service.CorBorrachaService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class CorBorrachaResourceTest {

    @Inject
    CorBorrachaService corService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/cores-borracha")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        CorBorrachaDTO dto = new CorBorrachaDTO("Borracha Azul", "#0000FF");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when().post("/cores-borracha")
            .then()
                .statusCode(200)
                .body(
                    "id", notNullValue(),
                    "nome", is("Borracha Azul"),
                    "cor", is("#0000FF")
                );
    }

    @Test
    void testAlterar() {
        CorBorrachaDTO dto = new CorBorrachaDTO("Borracha Original", "#FF0000");
        id = corService.create(dto).id();

        CorBorrachaDTO dtoAlterado = new CorBorrachaDTO("Borracha Alterada", "#00FF00");

        given()
            .contentType(ContentType.JSON)
            .body(dtoAlterado)
            .when().put("/cores-borracha/" + id)
            .then()
                .statusCode(200);

        CorBorrachaResponseDTO response = corService.findById(id);
        assertThat(response.nome(), is("Borracha Alterada"));
        assertThat(response.cor(), is("#00FF00"));
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/cores-borracha/" + id)
            .then()
                .statusCode(204);

        try {
            corService.findById(id);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Cor da borracha não encontrada."));
        }
    }
}

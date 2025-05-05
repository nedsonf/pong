package br.unitins.pong.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import br.unitins.pong.dto.EspessuraBorrachaDTO;
import br.unitins.pong.dto.EspessuraBorrachaResponseDTO;
import br.unitins.pong.service.EspessuraBorrachaService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class EspessuraBorrachaResourceTest {

    @Inject
    EspessuraBorrachaService espessuraService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/espessuras-borracha")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        EspessuraBorrachaDTO dto = new EspessuraBorrachaDTO(1.9);

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when().post("/espessuras-borracha")
            .then()
                .statusCode(200)
                .body(
                    "id", notNullValue(),
                    "espessura", is(1.9F)  // usa F para comparação com float/double
                );
    }

    @Test
    void testAlterar() {
        EspessuraBorrachaDTO dto = new EspessuraBorrachaDTO(2.0);
        id = espessuraService.create(dto).id();

        EspessuraBorrachaDTO dtoAlterado = new EspessuraBorrachaDTO(1.4);

        given()
            .contentType(ContentType.JSON)
            .body(dtoAlterado)
            .when().put("/espessuras-borracha/" + id)
            .then()
                .statusCode(200);

        EspessuraBorrachaResponseDTO response = espessuraService.findById(id);
        assertThat(response.espessura(), is(1.4));
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/espessuras-borracha/" + id)
            .then()
                .statusCode(204);

        try {
            espessuraService.findById(id);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Espessura da borracha não encontrada."));
        }
    }
}

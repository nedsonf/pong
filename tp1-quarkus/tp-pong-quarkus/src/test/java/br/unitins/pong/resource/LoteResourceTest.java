package br.unitins.pong.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import br.unitins.pong.dto.LoteDTO;
import br.unitins.pong.dto.LoteResponseDTO;
import br.unitins.pong.service.LoteService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class LoteResourceTest {

    @Inject
    LoteService loteService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/lotes")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        LoteDTO dto = new LoteDTO("Lote Teste");

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when().post("/lotes")
            .then()
                .statusCode(200)
                .body(
                    "id", notNullValue(),
                    "descricao", is("Lote Teste")
                );
    }

    @Test
    void testAlterar() {
        LoteDTO dto = new LoteDTO("Lote Inicial");
        id = loteService.create(dto).id();

        LoteDTO dtoAlterado = new LoteDTO("Lote Atualizado");

        given()
            .contentType(ContentType.JSON)
            .body(dtoAlterado)
            .when().put("/lotes/" + id)
            .then()
                .statusCode(200);

        LoteResponseDTO response = loteService.findById(id);
        assertThat(response.descricao(), is("Lote Atualizado"));
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/lotes/" + id)
            .then()
                .statusCode(204);

        try {
            loteService.findById(id);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Lote não encontrado."));
        }
    }
}

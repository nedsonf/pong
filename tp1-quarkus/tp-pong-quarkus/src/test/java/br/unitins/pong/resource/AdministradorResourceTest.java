package br.unitins.pong.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import br.unitins.pong.dto.AdministradorDTO;
import br.unitins.pong.dto.AdministradorResponseDTO;
import br.unitins.pong.service.AdministradorService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class AdministradorResourceTest {

    @Inject
    AdministradorService administradorService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/administradores")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        AdministradorDTO dto = new AdministradorDTO(
            "João Admin",
            "joao@admin.com",
            "senha123",
            "ADM001"
        );

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when().post("/administradores")
            .then()
                .statusCode(200)
                .body(
                    "id", notNullValue(),
                    "nome", is("João Admin"),
                    "email", is("joao@admin.com"),
                    "idFuncionario", is("ADM001")
                );
    }

    @Test
    void testAlterar() {
        AdministradorDTO dto = new AdministradorDTO(
            "Maria Admin",
            "maria@admin.com",
            "senha456",
            "ADM002"
        );

        id = administradorService.create(dto).id();

        AdministradorDTO dtoAlterado = new AdministradorDTO(
            "Maria Alterada",
            "maria@nova.com",
            "novaSenha",
            "ADM003"
        );

        given()
            .contentType(ContentType.JSON)
            .body(dtoAlterado)
            .when().put("/administradores/" + id)
            .then()
                .statusCode(200);

        AdministradorResponseDTO response = administradorService.findById(id);
        assertThat(response.nome(), is("Maria Alterada"));
        assertThat(response.email(), is("maria@nova.com"));
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/administradores/" + id)
            .then()
                .statusCode(204);

        try {
            administradorService.findById(id);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Administrador não encontrado."));
        }
    }
}

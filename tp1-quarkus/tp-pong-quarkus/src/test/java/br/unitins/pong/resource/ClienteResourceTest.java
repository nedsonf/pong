package br.unitins.pong.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import br.unitins.pong.dto.ClienteDTO;
import br.unitins.pong.dto.ClienteResponseDTO;
import br.unitins.pong.service.ClienteService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ClienteResourceTest {

    @Inject
    ClienteService clienteService;

    static Long id = null;

    @Test
    void testBuscarTodos() {
        given()
            .when().get("/clientes")
            .then()
                .statusCode(200);
    }

    @Test
    void testIncluir() {
        ClienteDTO dto = new ClienteDTO(
            "Ana Cliente",
            "ana@cliente.com",
            "12345678900",
            "77010000",
            "Rua Teste, 123",
            "senhaSegura"
        );

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when().post("/clientes")
            .then()
                .statusCode(200)
                .body(
                    "id", notNullValue(),
                    "nome", is("Ana Cliente"),
                    "email", is("ana@cliente.com"),
                    "cpf", is("12345678900"),
                    "cep", is("77010000")
                );
    }

    @Test
    void testAlterar() {
        ClienteDTO dto = new ClienteDTO(
            "Carlos Original",
            "carlos@cliente.com",
            "22233344400",
            "77020000",
            "Av. Inicial, 456",
            "minhasenha"
        );

        id = clienteService.create(dto).id();

        ClienteDTO dtoAlterado = new ClienteDTO(
            "Carlos Alterado",
            "carlosnovo@cliente.com",
            "22233344400",
            "77030000",
            "Av. Alterada, 789",
            "novasenha"
        );

        given()
            .contentType(ContentType.JSON)
            .body(dtoAlterado)
            .when().put("/clientes/" + id)
            .then()
                .statusCode(200);

        ClienteResponseDTO response = clienteService.findById(id);
        assertThat(response.nome(), is("Carlos Alterado"));
        assertThat(response.email(), is("carlosnovo@cliente.com"));
    }

    @Test
    void testApagar() {
        given()
            .when().delete("/clientes/" + id)
            .then()
                .statusCode(204);

        try {
            clienteService.findById(id);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Cliente não encontrado."));
        }
    }
}

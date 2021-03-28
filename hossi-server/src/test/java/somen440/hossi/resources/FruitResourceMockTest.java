package somen440.hossi.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import somen440.hossi.di.repository.RepositoryInjection;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class FruitResourceMockTest {

    @BeforeAll
    public static void initAll() {
        RepositoryInjection.useMock();
    }

    @Test
    public void testList() {
        given()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when().get("/fruits")
                .then()
                .statusCode(200)
                .body("fruits.size()", is(0));
    }
}

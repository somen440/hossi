package org.somen440.hossi.resources;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.somen440.hossi.di.repository.RepositoryInjection;
import org.somen440.hossi.di.usecases.UseCaseInjection;

@QuarkusTest
public class FruitResourceMockTest {

  @BeforeAll
  public static void initAll() {
    RepositoryInjection.useMock();
    UseCaseInjection.useNormal();
  }

  @Test
  public void testList() {
    given()
        .header("Content-Type", MediaType.APPLICATION_JSON)
        .when()
        .get("/fruits")
        .then()
        .statusCode(200)
        .body("fruits.size()", is(0));
  }
}

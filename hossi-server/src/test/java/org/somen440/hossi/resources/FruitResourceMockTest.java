package org.somen440.hossi.resources;

import javax.ws.rs.core.MediaType;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.somen440.hossi.di.repository.RepositoryInjection;
import org.somen440.hossi.di.usecases.UseCaseInjection;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

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

package org.somen440.hossi.resources;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

import io.quarkus.test.junit.QuarkusTest;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HealthResourceTest {

  @Test
  public void testCheck() {
    given()
        .header("Content-Type", MediaType.APPLICATION_JSON)
        .when()
        .get("/health")
        .then()
        .statusCode(200)
        .body("results.size()", is(1), "results.service", containsInAnyOrder("firestore"));
  }
}

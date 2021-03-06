package org.somen440.hossi.resources;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;

import io.quarkus.test.junit.QuarkusTest;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.somen440.hossi.di.repository.RepositoryInjection;
import org.somen440.hossi.di.usecases.UseCaseInjection;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FruitResourceTest {

  @BeforeAll
  public static void initAll() {
    RepositoryInjection.useInmemory();
    UseCaseInjection.useNormal();
  }

  @Test
  @Order(1)
  public void testList() {
    given()
        .header("Content-Type", MediaType.APPLICATION_JSON)
        .when()
        .get("/fruits")
        .then()
        .statusCode(200)
        .body(
            "fruits.size()",
            is(2),
            "fruits.name",
            containsInAnyOrder("Apple", "Pineapple"),
            "fruits.description",
            containsInAnyOrder("Winter fruit", "Tropical fruit"));
  }

  @Test
  @Order(2)
  public void testAdd() {
    given()
        .body("{\"name\":\"Pear\", \"description\":\"Winter fruit\"}")
        .header("Content-Type", MediaType.APPLICATION_JSON)
        .when()
        .post("/fruits")
        .then()
        .statusCode(200)
        .body("fruit.name", containsString("Pear"));
  }

  @Test
  @Order(3)
  public void testAddedList() {
    given()
        .header("Content-Type", MediaType.APPLICATION_JSON)
        .when()
        .get("/fruits")
        .then()
        .statusCode(200)
        .body(
            "fruits.size()",
            is(3),
            "fruits.name",
            containsInAnyOrder("Apple", "Pineapple", "Pear"),
            "fruits.description",
            containsInAnyOrder("Winter fruit", "Tropical fruit", "Winter fruit"));
  }

  @Test
  @Order(4)
  public void testDelete() {
    given()
        .header("Content-Type", MediaType.APPLICATION_JSON)
        .when()
        .delete("/fruits/3")
        .then()
        .statusCode(204);
  }

  @Test
  @Order(5)
  public void testDeletedList() {
    given()
        .header("Content-Type", MediaType.APPLICATION_JSON)
        .when()
        .get("/fruits")
        .then()
        .statusCode(200)
        .body(
            "fruits.size()",
            is(2),
            "fruits.name",
            containsInAnyOrder("Apple", "Pineapple"),
            "fruits.description",
            containsInAnyOrder("Winter fruit", "Tropical fruit"));
  }

  @Test
  @Order(888)
  public void testAddWithInvalidArgumentException() {
    given()
        .body("{\"name\":\"Pear\"}")
        .header("Content-Type", MediaType.APPLICATION_JSON)
        .when()
        .post("/fruits")
        .then()
        .statusCode(400)
        .body(containsString("Bad Request"));
  }

  @Test
  @Order(999)
  public void testListWithRuntimeException() {
    UseCaseInjection.useError();

    given()
        .header("Content-Type", MediaType.APPLICATION_JSON)
        .when()
        .get("/fruits")
        .then()
        .statusCode(500)
        .body(containsString("Internal Server Error"));
  }
}

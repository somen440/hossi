package org.somen440.hossi.resources;

import java.util.HashSet;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.somen440.hossi.di.usecases.fruits.FruitUseCaseDI;
import org.somen440.hossi.exception.InvalidArgumentException;
import org.somen440.hossi.resources.schemas.fruits.Fruit;
import org.somen440.hossi.resources.schemas.fruits.FruitAddRequest;
import org.somen440.hossi.resources.schemas.fruits.FruitAddResponse;
import org.somen440.hossi.resources.schemas.fruits.FruitListResponse;
import org.somen440.hossi.usecases.fruits.add.FruitAddInputData;
import org.somen440.hossi.usecases.fruits.add.FruitAddOutputData;
import org.somen440.hossi.usecases.fruits.delete.FruitDeleteInputData;
import org.somen440.hossi.usecases.fruits.list.FruitListInputData;
import org.somen440.hossi.usecases.fruits.list.FruitListOutputData;

@Path("/fruits")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FruitResource {

  private static final Logger LOG = Logger.getLogger(FruitResource.class);

  @Inject FruitUseCaseDI di;

  @Inject Validator validator;

  @GET
  public FruitListResponse list() {
    final var input = new FruitListInputData();
    FruitListOutputData output;

    try {
      output = di.listUseCase().handle(input);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    final var fruits =
        output.fruits.stream()
            .map(fruitData -> new Fruit(fruitData.id, fruitData.name, fruitData.description))
            .collect(Collectors.toList());

    LOG.info(String.format("list size=%d", fruits.size()));

    return new FruitListResponse(new HashSet<>(fruits));
  }

  @POST
  public FruitAddResponse add(FruitAddRequest req) throws InvalidArgumentException {
    var violations = validator.validate(req);
    if (!violations.isEmpty()) {
      throw new InvalidArgumentException(violations.toString());
    }

    final var input = new FruitAddInputData(req.name, req.description);
    FruitAddOutputData output;

    try {
      output = di.addUseCase().handle(input);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    LOG.info(String.format("add id=%s", output.fruit.id));

    return new FruitAddResponse(
        new Fruit(output.fruit.id, output.fruit.name, output.fruit.description));
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam String id) {
    try {
      di.deleteUseCase().handle(new FruitDeleteInputData(id));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    LOG.info(String.format("delete id=%s", id));
  }
}

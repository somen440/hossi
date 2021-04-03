package org.somen440.hossi.resources;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.somen440.hossi.di.usecases.fruits.FruitUseCaseDI;
import org.somen440.hossi.exception.InvalidArgumentException;
import org.somen440.hossi.resources.schemas.fruits.Fruit;
import org.somen440.hossi.resources.schemas.fruits.FruitAddRequest;
import org.somen440.hossi.resources.schemas.fruits.FruitAddResponse;
import org.somen440.hossi.resources.schemas.fruits.FruitListResponse;
import org.somen440.hossi.usecases.fruits.add.FruitAddInputData;
import org.somen440.hossi.usecases.fruits.delete.FruitDeleteInputData;
import org.somen440.hossi.usecases.fruits.list.FruitListInputData;

@Path("/fruits")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FruitResource {

  private static final Logger LOG = Logger.getLogger(FruitResource.class);

  @Inject FruitUseCaseDI di;

  @Inject Validator validator;

  @GET
  public FruitListResponse list() throws Exception {
    final var input = new FruitListInputData();
    final var fruits =
        di.listUseCase().handle(input).fruits.stream()
            .map(fruitData -> new Fruit(fruitData.id, fruitData.name, fruitData.description))
            .collect(Collectors.toList());

    LOG.info(String.format("list size=%d", fruits.size()));

    return new FruitListResponse(new HashSet<>(fruits));
  }

  @POST
  public FruitAddResponse add(FruitAddRequest req) throws Exception {
    var violations = validator.validate(req);
    if (!violations.isEmpty()) {
      throw new InvalidArgumentException(violations.toString());
    }

    if (req.name.isEmpty() || req.description.isEmpty()) {
      throw new InvalidArgumentException(
          String.format("request empty name=%s description=%s", req.name, req.description));
    }

    final var input = new FruitAddInputData(req.name, req.description);
    final var output = di.addUseCase().handle(input);

    LOG.info(String.format("add id=%s", output.fruit.id));

    return new FruitAddResponse(
        new Fruit(output.fruit.id, output.fruit.name, output.fruit.description));
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam String id) throws Exception {
    di.deleteUseCase().handle(new FruitDeleteInputData(id));

    LOG.info(String.format("delete id=%s", id));
  }
}

package somen440.hossi.resources;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import somen440.hossi.di.usecases.fruits.FruitUseCaseDI;
import somen440.hossi.resources.schemas.fruits.Fruit;
import somen440.hossi.resources.schemas.fruits.FruitAddRequest;
import somen440.hossi.resources.schemas.fruits.FruitAddResponse;
import somen440.hossi.resources.schemas.fruits.FruitListResponse;
import somen440.hossi.usecases.fruits.add.FruitAddInputData;
import somen440.hossi.usecases.fruits.delete.FruitDeleteInputData;
import somen440.hossi.usecases.fruits.list.FruitListInputData;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.stream.Collectors;

@Path("/fruits")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FruitResource {

    private static final Logger LOG = Logger.getLogger(FruitResource.class);

    @Inject
    FruitUseCaseDI di;

    @GET
    public FruitListResponse list() {
        final var input = new FruitListInputData();
        final var fruits = di.listUseCase().handle(input).fruits.stream().map(
                fruitData -> new Fruit(fruitData.id, fruitData.name, fruitData.description)
        ).collect(Collectors.toList());

        LOG.info(String.format("list size=%d", fruits.size()));

        return new FruitListResponse(new HashSet<>(fruits));
    }

    @POST
    public FruitAddResponse add(FruitAddRequest req) {
        final var input = new FruitAddInputData(req.name, req.description);
        final var output = di.addUseCase().handle(input);

        LOG.info(String.format("add id=%d", output.fruit.id));

        return new FruitAddResponse(new Fruit(output.fruit.id, output.fruit.name, output.fruit.description));
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam int id) {
        di.deleteUseCase().handle(new FruitDeleteInputData(id));

        LOG.info(String.format("delete id=%d", id));
    }
}
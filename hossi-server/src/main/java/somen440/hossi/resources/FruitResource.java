package somen440.hossi.resources;

import org.jboss.logging.Logger;
import somen440.hossi.usecases.fruits.FruitData;
import somen440.hossi.usecases.fruits.add.FruitAddInputData;
import somen440.hossi.usecases.fruits.add.FruitAddOutputData;
import somen440.hossi.usecases.fruits.add.FruitAddUseCase;
import somen440.hossi.usecases.fruits.delete.FruitDeleteInputData;
import somen440.hossi.usecases.fruits.delete.FruitDeleteOutputData;
import somen440.hossi.usecases.fruits.delete.FruitDeleteUseCase;
import somen440.hossi.usecases.fruits.list.FruitListInputData;
import somen440.hossi.usecases.fruits.list.FruitListOutputData;
import somen440.hossi.usecases.fruits.list.FruitListUseCase;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/fruits")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FruitResource {

    private static final Logger LOG = Logger.getLogger(FruitResource.class);

    @Inject
    FruitAddUseCase fruitAddUseCase;

    @Inject
    FruitListUseCase fruitListUseCase;

    @Inject
    FruitDeleteUseCase fruitDeleteUseCase;

    @GET
    public FruitListOutputData list(FruitListInputData input) {
        LOG.info("list");
        return this.fruitListUseCase.handle(input);
    }

    @POST
    public FruitAddOutputData add(FruitAddInputData input) {
        LOG.info("add");
        return this.fruitAddUseCase.handle(input);
    }

    @DELETE
    public FruitDeleteOutputData delete(FruitDeleteInputData input) {
        LOG.info("delete");
        return this.fruitDeleteUseCase.handle(input);
    }
}
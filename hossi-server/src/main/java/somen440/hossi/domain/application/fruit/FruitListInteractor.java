package somen440.hossi.domain.application.fruit;

import somen440.hossi.di.RepositoryInjection;
import somen440.hossi.domain.model.fruit.FruitRepository;
import somen440.hossi.usecases.fruits.FruitData;
import somen440.hossi.usecases.fruits.list.FruitListInputData;
import somen440.hossi.usecases.fruits.list.FruitListOutputData;
import somen440.hossi.usecases.fruits.list.FruitListUseCase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.stream.Collectors;

@ApplicationScoped
public class FruitListInteractor implements FruitListUseCase {

    @Inject
    RepositoryInjection repositoryInjection;

    @Override
    public FruitListOutputData handle(FruitListInputData inputData) {
        final var fruits = repositoryInjection.fruitRepository().findAll().stream().map(
                fruit -> new FruitData(fruit.id, fruit.name, fruit.description)
        ).collect(Collectors.toList());

        return new FruitListOutputData(new HashSet<>(fruits));
    }
}

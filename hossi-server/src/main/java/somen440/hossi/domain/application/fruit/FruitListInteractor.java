package somen440.hossi.domain.application.fruit;

import somen440.hossi.di.repository.RepositoryInjection;
import somen440.hossi.di.repository.fruits.FruitRepositoryDI;
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

    FruitRepository fruitRepository;

    public FruitListInteractor() {}

    public FruitListInteractor(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public FruitListOutputData handle(FruitListInputData inputData) {
        final var fruits = fruitRepository.findAll().stream().map(
                fruit -> new FruitData(fruit.id, fruit.name, fruit.description)
        ).collect(Collectors.toList());

        return new FruitListOutputData(new HashSet<>(fruits));
    }
}

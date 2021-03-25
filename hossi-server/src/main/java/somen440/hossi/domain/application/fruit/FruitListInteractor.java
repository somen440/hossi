package somen440.hossi.domain.application.fruit;

import somen440.hossi.domain.model.fruit.FruitRepository;
import somen440.hossi.usecases.fruits.FruitData;
import somen440.hossi.usecases.fruits.list.FruitListInputData;
import somen440.hossi.usecases.fruits.list.FruitListOutputData;
import somen440.hossi.usecases.fruits.list.FruitListUseCase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashSet;

@ApplicationScoped
public class FruitListInteractor implements FruitListUseCase {

    @Inject
    FruitRepository fruitRepository;

    @Override
    public FruitListOutputData handle(FruitListInputData inputData) {
        final var fruits = fruitRepository.findAll().stream().map(
                fruit -> new FruitData(fruit.id, fruit.name, fruit.description)
        ).toList();

        return new FruitListOutputData(new HashSet<>(fruits));
    }
}

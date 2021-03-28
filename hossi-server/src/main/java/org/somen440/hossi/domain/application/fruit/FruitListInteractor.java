package org.somen440.hossi.domain.application.fruit;

import org.somen440.hossi.usecases.fruits.FruitData;
import org.somen440.hossi.usecases.fruits.list.FruitListInputData;
import org.somen440.hossi.usecases.fruits.list.FruitListOutputData;
import org.somen440.hossi.usecases.fruits.list.FruitListUseCase;
import org.somen440.hossi.domain.model.fruit.FruitRepository;

import javax.enterprise.context.ApplicationScoped;
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

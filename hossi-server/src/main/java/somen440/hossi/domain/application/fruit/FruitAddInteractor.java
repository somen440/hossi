package somen440.hossi.domain.application.fruit;

import somen440.hossi.di.repository.fruits.FruitRepositoryDI;
import somen440.hossi.domain.model.fruit.FruitRepository;
import somen440.hossi.usecases.fruits.FruitData;
import somen440.hossi.usecases.fruits.add.FruitAddInputData;
import somen440.hossi.usecases.fruits.add.FruitAddOutputData;
import somen440.hossi.usecases.fruits.add.FruitAddUseCase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FruitAddInteractor implements FruitAddUseCase {

    @Inject
    FruitRepositoryDI fruitRepositoryDI;

    @Override
    public FruitAddOutputData handle(FruitAddInputData inputData) {
        final var fruit = fruitRepositoryDI.repository().save(inputData.name, inputData.description);

        return new FruitAddOutputData(new FruitData(fruit.id, fruit.name, fruit.description));
    }
}

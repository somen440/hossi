package somen440.hossi.domain.application.fruit;

import somen440.hossi.di.repository.fruits.FruitRepositoryDI;
import somen440.hossi.usecases.fruits.delete.FruitDeleteInputData;
import somen440.hossi.usecases.fruits.delete.FruitDeleteOutputData;
import somen440.hossi.usecases.fruits.delete.FruitDeleteUseCase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FruitDeleteInteractor implements FruitDeleteUseCase {

    @Inject
    FruitRepositoryDI fruitRepositoryDI;

    @Override
    public FruitDeleteOutputData handle(FruitDeleteInputData inputData) {
        fruitRepositoryDI.repository().remove(inputData.id);

        return new FruitDeleteOutputData();
    }
}

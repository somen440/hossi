package somen440.hossi.domain.application.fruit;

import somen440.hossi.domain.model.fruit.FruitRepository;
import somen440.hossi.usecases.fruits.delete.FruitDeleteInputData;
import somen440.hossi.usecases.fruits.delete.FruitDeleteOutputData;
import somen440.hossi.usecases.fruits.delete.FruitDeleteUseCase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FruitDeleteInteractor implements FruitDeleteUseCase {

    @Inject
    FruitRepository fruitRepository;

    @Override
    public FruitDeleteOutputData handle(FruitDeleteInputData inputData) {
        this.fruitRepository.remove(inputData.id);

        return new FruitDeleteOutputData();
    }
}

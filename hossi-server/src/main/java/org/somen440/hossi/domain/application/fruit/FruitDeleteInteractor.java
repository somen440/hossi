package org.somen440.hossi.domain.application.fruit;

import org.somen440.hossi.domain.model.fruit.FruitRepository;
import org.somen440.hossi.usecases.fruits.delete.FruitDeleteInputData;
import org.somen440.hossi.usecases.fruits.delete.FruitDeleteOutputData;
import org.somen440.hossi.usecases.fruits.delete.FruitDeleteUseCase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitDeleteInteractor implements FruitDeleteUseCase {

  FruitRepository fruitRepository;

  public FruitDeleteInteractor() {}

  public FruitDeleteInteractor(FruitRepository fruitRepository) {
    this.fruitRepository = fruitRepository;
  }

  @Override
  public FruitDeleteOutputData handle(FruitDeleteInputData inputData) {
    fruitRepository.remove(inputData.id);

    return new FruitDeleteOutputData();
  }
}

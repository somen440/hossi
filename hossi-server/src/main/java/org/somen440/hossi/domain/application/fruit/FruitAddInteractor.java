package org.somen440.hossi.domain.application.fruit;

import org.somen440.hossi.domain.model.fruit.FruitRepository;
import org.somen440.hossi.usecases.fruits.FruitData;
import org.somen440.hossi.usecases.fruits.add.FruitAddInputData;
import org.somen440.hossi.usecases.fruits.add.FruitAddOutputData;
import org.somen440.hossi.usecases.fruits.add.FruitAddUseCase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitAddInteractor implements FruitAddUseCase {

  FruitRepository fruitRepository;

  public FruitAddInteractor() {}

  public FruitAddInteractor(FruitRepository fruitRepository) {
    this.fruitRepository = fruitRepository;
  }

  @Override
  public FruitAddOutputData handle(FruitAddInputData inputData) {
    final var fruit = fruitRepository.save(inputData.name, inputData.description);

    return new FruitAddOutputData(new FruitData(fruit.id, fruit.name, fruit.description));
  }
}

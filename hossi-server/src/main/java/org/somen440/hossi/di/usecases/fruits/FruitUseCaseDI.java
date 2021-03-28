package org.somen440.hossi.di.usecases.fruits;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.somen440.hossi.di.repository.fruits.FruitRepositoryDI;
import org.somen440.hossi.domain.application.fruit.FruitAddInteractor;
import org.somen440.hossi.domain.application.fruit.FruitDeleteInteractor;
import org.somen440.hossi.domain.application.fruit.FruitListInteractor;
import org.somen440.hossi.usecases.fruits.add.FruitAddUseCase;
import org.somen440.hossi.usecases.fruits.delete.FruitDeleteUseCase;
import org.somen440.hossi.usecases.fruits.list.FruitListUseCase;

@ApplicationScoped
public class FruitUseCaseDI {

  @Inject FruitRepositoryDI fruitRepositoryDi;

  public FruitAddUseCase addUseCase() {
    return new FruitAddInteractor(fruitRepositoryDi.repository());
  }

  public FruitListUseCase listUseCase() {
    return new FruitListInteractor(fruitRepositoryDi.repository());
  }

  public FruitDeleteUseCase deleteUseCase() {
    return new FruitDeleteInteractor(fruitRepositoryDi.repository());
  }
}

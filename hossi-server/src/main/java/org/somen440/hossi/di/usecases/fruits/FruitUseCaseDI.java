package org.somen440.hossi.di.usecases.fruits;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.io.IOException;

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

  public FruitAddUseCase addUseCase() throws IOException {
    return new FruitAddInteractor(fruitRepositoryDi.repository());
  }

  public FruitListUseCase listUseCase() throws IOException {
    return new FruitListInteractor(fruitRepositoryDi.repository());
  }

  public FruitDeleteUseCase deleteUseCase() throws IOException {
    return new FruitDeleteInteractor(fruitRepositoryDi.repository());
  }
}

package org.somen440.hossi.domain.application.fruit;

import javax.enterprise.context.ApplicationScoped;

import org.somen440.hossi.usecases.fruits.list.FruitListInputData;
import org.somen440.hossi.usecases.fruits.list.FruitListOutputData;
import org.somen440.hossi.usecases.fruits.list.FruitListUseCase;

@ApplicationScoped
public class ErrorFruitListInteractor implements FruitListUseCase {

  @Override
  public FruitListOutputData handle(FruitListInputData inputData) throws Exception {
    throw new RuntimeException("test exception");
  }
}

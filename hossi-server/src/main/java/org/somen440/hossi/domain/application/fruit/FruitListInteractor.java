package org.somen440.hossi.domain.application.fruit;

import java.util.HashSet;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import org.somen440.hossi.domain.model.fruit.FruitRepository;
import org.somen440.hossi.usecases.fruits.FruitData;
import org.somen440.hossi.usecases.fruits.list.FruitListInputData;
import org.somen440.hossi.usecases.fruits.list.FruitListOutputData;
import org.somen440.hossi.usecases.fruits.list.FruitListUseCase;

@ApplicationScoped
public class FruitListInteractor implements FruitListUseCase {

  FruitRepository fruitRepository;

  public FruitListInteractor() {}

  public FruitListInteractor(FruitRepository fruitRepository) {
    this.fruitRepository = fruitRepository;
  }

  @Override
  public FruitListOutputData handle(FruitListInputData inputData) throws Exception {
    final var fruits =
        fruitRepository.findAll().stream()
            .map(fruit -> new FruitData(fruit.id, fruit.name, fruit.description))
            .collect(Collectors.toList());

    return new FruitListOutputData(new HashSet<>(fruits));
  }
}

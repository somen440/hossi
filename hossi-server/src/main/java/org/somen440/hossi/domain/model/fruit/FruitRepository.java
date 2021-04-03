package org.somen440.hossi.domain.model.fruit;

import java.util.Set;
import java.util.concurrent.ExecutionException;

public interface FruitRepository {

  FruitModel save(String name, String description)
      throws ExecutionException, InterruptedException, Exception;

  void remove(String id);

  Set<FruitModel> findAll() throws ExecutionException, InterruptedException, Exception;
}

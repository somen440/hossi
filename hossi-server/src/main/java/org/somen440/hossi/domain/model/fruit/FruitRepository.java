package org.somen440.hossi.domain.model.fruit;

import java.util.Set;
import java.util.concurrent.ExecutionException;

public interface FruitRepository {

  FruitModel save(String name, String description);

  void remove(int id);

  Set<FruitModel> findAll() throws ExecutionException, InterruptedException, Exception;
}

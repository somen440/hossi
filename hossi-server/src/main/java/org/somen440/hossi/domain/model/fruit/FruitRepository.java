package org.somen440.hossi.domain.model.fruit;

import java.util.Set;

public interface FruitRepository {

  FruitModel save(String name, String description) throws Exception;

  void remove(String id);

  Set<FruitModel> findAll() throws Exception;
}

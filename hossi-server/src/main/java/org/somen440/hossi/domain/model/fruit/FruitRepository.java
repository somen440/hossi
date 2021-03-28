package org.somen440.hossi.domain.model.fruit;

import java.util.Set;

public interface FruitRepository {
  Fruit save(String name, String description);

  void remove(int id);

  Set<Fruit> findAll();
}

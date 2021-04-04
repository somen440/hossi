package org.somen440.hossi.infrastructure.persistent.fruit;

import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import org.somen440.hossi.domain.model.fruit.FruitModel;
import org.somen440.hossi.domain.model.fruit.FruitRepository;

@ApplicationScoped
public class EmptyFruitRepository implements FruitRepository {

  @Override
  public FruitModel save(String name, String description) {
    return new FruitModel("1", "mock", "mock");
  }

  @Override
  public void remove(String id) {}

  @Override
  public Set<FruitModel> findAll() {
    return new HashSet<>();
  }
}

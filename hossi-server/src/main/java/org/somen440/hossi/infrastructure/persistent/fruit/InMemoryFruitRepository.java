package org.somen440.hossi.infrastructure.persistent.fruit;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import org.jboss.logging.Logger;
import org.somen440.hossi.domain.model.fruit.FruitModel;
import org.somen440.hossi.domain.model.fruit.FruitRepository;

@ApplicationScoped
public class InMemoryFruitRepository implements FruitRepository {

  private static final Logger LOG = Logger.getLogger(InMemoryFruitRepository.class);

  private final Set<FruitModel> fruitModels =
      Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

  public InMemoryFruitRepository() {
    this.fruitModels.add(new FruitModel(1, "Apple", "Winter fruit"));
    this.fruitModels.add(new FruitModel(2, "Pineapple", "Tropical fruit"));
  }

  @Override
  public FruitModel save(String name, String description) {
    final var id = fruitModels.size() + 1;
    final var fruit = new FruitModel(id, name, description);
    this.fruitModels.add(fruit);

    LOG.debug(String.format("save 成功 id=%d name=%s description=%s", id, name, description));

    return fruit;
  }

  @Override
  public void remove(int id) {
    LOG.debug(String.format("remove 成功 id=%d", id));

    this.fruitModels.removeIf(fruitModel -> fruitModel.id == id);
  }

  @Override
  public Set<FruitModel> findAll() {
    LOG.debug(String.format("findAll 成功 length=%d", fruitModels.size()));

    return fruitModels;
  }
}

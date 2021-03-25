package somen440.hossi.infrastructure.persistent.fruit;

import org.jboss.logging.Logger;
import somen440.hossi.domain.model.fruit.Fruit;
import somen440.hossi.domain.model.fruit.FruitRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@ApplicationScoped
public class InMemoryFruitRepository implements FruitRepository {

    private static final Logger LOG = Logger.getLogger(InMemoryFruitRepository.class);

    private final Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public InMemoryFruitRepository() {
        this.fruits.add(new Fruit(1, "Apple", "Winter fruit"));
        this.fruits.add(new Fruit(2, "Pineapple", "Tropical fruit"));
    }

    @Override
    public Fruit save(String name, String description) {
        final var id = fruits.size() + 1;
        final var fruit = new Fruit(id, name, description);
        this.fruits.add(fruit);

        LOG.debug(String.format("save 成功 id=%d name=%s description=%s", id, name, description));

        return fruit;
    }

    @Override
    public void remove(int id) {
        LOG.debug(String.format("remove 成功 id=%d", id));

        this.fruits.removeIf(fruit -> fruit.id == id);
    }

    @Override
    public Set<Fruit> findAll() {
        LOG.debug(String.format("findAll 成功 length=%d", fruits.size()));

        return fruits;
    }
}

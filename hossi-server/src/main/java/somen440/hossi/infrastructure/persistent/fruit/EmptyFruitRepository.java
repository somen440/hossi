package somen440.hossi.infrastructure.persistent.fruit;

import somen440.hossi.domain.model.fruit.Fruit;
import somen440.hossi.domain.model.fruit.FruitRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class EmptyFruitRepository implements FruitRepository {

    @Override
    public Fruit save(String name, String description) {
        return new Fruit(1, "mock", "mock");
    }

    @Override
    public void remove(int id) {}

    @Override
    public Set<Fruit> findAll() {
        return new HashSet<>();
    }
}

package org.somen440.hossi.di.repository.fruits;

import org.somen440.hossi.di.repository.RepositoryInjection;
import org.somen440.hossi.domain.model.fruit.FruitRepository;
import org.somen440.hossi.infrastructure.persistent.fruit.EmptyFruitRepository;
import org.somen440.hossi.infrastructure.persistent.fruit.InMemoryFruitRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FruitRepositoryDI {

    @Inject
    InMemoryFruitRepository inMemoryFruitRepository;

    @Inject
    EmptyFruitRepository emptyFruitRepository;

    public FruitRepository repository() {
        switch (RepositoryInjection.currentType()) {
            case INMEMORY:
                return inMemoryFruitRepository;
            case MOCK:
                return emptyFruitRepository;
        }
        throw new RuntimeException("未登録のタイプ");
    }
}

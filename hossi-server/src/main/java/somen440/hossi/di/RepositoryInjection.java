package somen440.hossi.di;

import somen440.hossi.domain.model.fruit.FruitRepository;
import somen440.hossi.infrastructure.persistent.fruit.InMemoryFruitRepository;
import somen440.hossi.infrastructure.persistent.fruit.MockFruitRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RepositoryInjection {

    public enum RepositoryType {
        INMEMORY,
        MOCK,
    }

    private static RepositoryType type = RepositoryType.INMEMORY;

    public static void useInmemory() {
        type = RepositoryType.INMEMORY;
    }

    public static void useMock() {
        type = RepositoryType.MOCK;
    }

    @Inject
    InMemoryFruitRepository inMemoryFruitRepository;

    @Inject
    MockFruitRepository mockFruitRepository;

    public FruitRepository fruitRepository() {
        switch (type) {
            case INMEMORY:
                return inMemoryFruitRepository;
            case MOCK:
                return mockFruitRepository;
        }
        throw new RuntimeException("未登録のタイプ");
    }
}

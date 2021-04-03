package org.somen440.hossi.di.repository.fruits;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.io.IOException;

import org.somen440.hossi.di.repository.RepositoryInjection;
import org.somen440.hossi.domain.model.fruit.FruitRepository;
import org.somen440.hossi.infrastructure.firestore.FirestoreBuilder;
import org.somen440.hossi.infrastructure.persistent.fruit.EmptyFruitRepository;
import org.somen440.hossi.infrastructure.persistent.fruit.FirebaseFruitRepository;
import org.somen440.hossi.infrastructure.persistent.fruit.InMemoryFruitRepository;

@ApplicationScoped
public class FruitRepositoryDI {

  @Inject InMemoryFruitRepository inMemoryFruitRepository;

  @Inject EmptyFruitRepository emptyFruitRepository;

  @Inject FirebaseFruitRepository firebaseFruitRepository;

  public FruitRepository repository() throws IOException {
    switch (RepositoryInjection.currentType()) {
      case FIREBASE:
        return new FirebaseFruitRepository(FirestoreBuilder.build());
      case INMEMORY:
        return inMemoryFruitRepository;
      case MOCK:
        return emptyFruitRepository;
    }
    throw new RuntimeException("未登録のタイプ");
  }
}

package org.somen440.hossi.di.repository.fruits;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.somen440.hossi.di.repository.RepositoryInjection;
import org.somen440.hossi.domain.model.fruit.FruitRepository;
import org.somen440.hossi.infrastructure.persistent.fruit.EmptyFruitRepository;
import org.somen440.hossi.infrastructure.persistent.fruit.InMemoryFruitRepository;

@ApplicationScoped
public class FruitRepositoryDI {

  @Inject InMemoryFruitRepository inMemoryFruitRepository;

  @Inject EmptyFruitRepository emptyFruitRepository;

  /**
   * 設定に応じて FruitRepository を返す.
   *
   * @return FruitRepository impl
   */
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

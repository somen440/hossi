package org.somen440.hossi.di.repository.health;

import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.somen440.hossi.domain.model.health.HealthRepository;
import org.somen440.hossi.infrastructure.persistent.health.FirestoreHealthRepository;

@ApplicationScoped
public class HealthRepositoryDi {

  @Inject FirestoreHealthRepository firestoreHealthRepository;

  /**
   * HealthRepository を実装した配列を返す.
   *
   * @return Set<HealthRepository>
   */
  public Set<HealthRepository> repositories() {
    var results = new HashSet<HealthRepository>();

    results.add(firestoreHealthRepository);
    // any health repository ...

    return results;
  }
}

package org.somen440.hossi.di.usecases.health;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.somen440.hossi.di.repository.health.HealthRepositoryDi;
import org.somen440.hossi.domain.application.health.HealthCheckInteractor;
import org.somen440.hossi.usecases.health.check.HealthCheckUseCase;

@ApplicationScoped
public class HealthUseCaseDi {

  @Inject HealthRepositoryDi healthRepositoryDi;

  public HealthCheckUseCase checkUseCase() {
    return new HealthCheckInteractor(healthRepositoryDi.repositories());
  }
}

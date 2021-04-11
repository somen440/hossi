package org.somen440.hossi.domain.application.health;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import org.somen440.hossi.domain.model.health.HealthModel;
import org.somen440.hossi.domain.model.health.HealthRepository;
import org.somen440.hossi.usecases.health.HealthData;
import org.somen440.hossi.usecases.health.check.HealthCheckInputData;
import org.somen440.hossi.usecases.health.check.HealthCheckOutputData;
import org.somen440.hossi.usecases.health.check.HealthCheckUseCase;

@ApplicationScoped
public class HealthCheckInteractor implements HealthCheckUseCase {

  private Set<HealthRepository> repositories;

  public HealthCheckInteractor() {}

  public HealthCheckInteractor(Set<HealthRepository> repositories) {
    this.repositories = repositories;
  }

  @Override
  public HealthCheckOutputData handle(HealthCheckInputData inputData) throws Exception {
    var results = new HashSet<HealthModel>();
    for (var repo : this.repositories) {
      var result = repo.check();
      results.add(result);
    }
    var convResults =
        results.stream().map(m -> new HealthData(m.service, m.ok)).collect(Collectors.toSet());
    return new HealthCheckOutputData(convResults);
  }
}

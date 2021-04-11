package org.somen440.hossi.domain.model.health;

import java.util.concurrent.ExecutionException;

public interface HealthRepository {

  public HealthModel check() throws ExecutionException, InterruptedException;
}

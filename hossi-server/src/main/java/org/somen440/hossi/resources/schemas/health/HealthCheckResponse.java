package org.somen440.hossi.resources.schemas.health;

import java.util.Set;

public class HealthCheckResponse {

  public Set<Health> results;

  public HealthCheckResponse() {}

  public HealthCheckResponse(Set<Health> results) {
    this.results = results;
  }
}

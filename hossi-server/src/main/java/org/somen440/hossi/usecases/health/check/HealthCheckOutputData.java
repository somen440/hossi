package org.somen440.hossi.usecases.health.check;

import java.util.Set;
import org.somen440.hossi.usecases.OutputData;
import org.somen440.hossi.usecases.health.HealthData;

public class HealthCheckOutputData implements OutputData {

  public Set<HealthData> results;

  public HealthCheckOutputData() {}

  public HealthCheckOutputData(Set<HealthData> results) {
    this.results = results;
  }
}

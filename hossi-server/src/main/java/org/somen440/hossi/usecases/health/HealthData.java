package org.somen440.hossi.usecases.health;

public class HealthData {

  public String service;
  public boolean ok;

  public HealthData() {}

  public HealthData(String service, boolean ok) {
    this.service = service;
    this.ok = ok;
  }
}

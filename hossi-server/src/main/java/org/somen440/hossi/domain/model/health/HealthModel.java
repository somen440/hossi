package org.somen440.hossi.domain.model.health;

public class HealthModel {

  public String service;
  public boolean ok;

  public HealthModel() {}

  public HealthModel(String service, boolean ok) {
    this.service = service;
    this.ok = ok;
  }
}

package org.somen440.hossi.resources.schemas.health;

public class Health {

  public String service;
  public boolean ok;

  public Health() {}

  public Health(String service, boolean ok) {
    this.service = service;
    this.ok = ok;
  }
}

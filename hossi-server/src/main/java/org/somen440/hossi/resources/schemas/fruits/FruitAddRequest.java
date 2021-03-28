package org.somen440.hossi.resources.schemas.fruits;

public class FruitAddRequest {

  public String name;
  public String description;

  public FruitAddRequest() {}

  public FruitAddRequest(String name, String description) {
    this.name = name;
    this.description = description;
  }
}

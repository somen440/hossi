package org.somen440.hossi.resources.schemas.fruits;

import javax.validation.constraints.NotBlank;

public class Fruit {

  @NotBlank(message = "ID may not be blank")
  public String id;

  @NotBlank(message = "name may not be blank")
  public String name;

  @NotBlank(message = "description may not be blank")
  public String description;

  public Fruit() {}

  public Fruit(String id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }
}

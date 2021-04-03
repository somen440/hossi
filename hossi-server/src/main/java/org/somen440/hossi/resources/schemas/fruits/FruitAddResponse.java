package org.somen440.hossi.resources.schemas.fruits;

import javax.validation.constraints.NotNull;

public class FruitAddResponse {

  @NotNull(message = "fruit may not be blank")
  public Fruit fruit;

  public FruitAddResponse() {}

  public FruitAddResponse(Fruit fruit) {
    this.fruit = fruit;
  }
}

package org.somen440.hossi.resources.schemas.fruits;

import java.util.Set;
import javax.validation.constraints.NotNull;

public class FruitListResponse {

  @NotNull(message = "fruit may not be blank")
  public Set<Fruit> fruits;

  public FruitListResponse() {}

  public FruitListResponse(Set<Fruit> fruits) {
    this.fruits = fruits;
  }
}

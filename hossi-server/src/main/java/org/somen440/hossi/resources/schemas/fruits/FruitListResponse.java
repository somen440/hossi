package org.somen440.hossi.resources.schemas.fruits;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class FruitListResponse {

  @NotNull(message = "fruit may not be blank")
  public Set<Fruit> fruits;

  public FruitListResponse() {}

  public FruitListResponse(Set<Fruit> fruits) {
    this.fruits = fruits;
  }
}

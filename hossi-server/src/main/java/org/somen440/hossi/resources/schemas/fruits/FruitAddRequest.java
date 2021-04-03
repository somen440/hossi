package org.somen440.hossi.resources.schemas.fruits;

import javax.validation.constraints.NotBlank;

public class FruitAddRequest {

  @NotBlank(message = "name may not be blank")
  public String name;

  @NotBlank(message = "description may not be blank")
  public String description;

  public FruitAddRequest() {}

  public FruitAddRequest(String name, String description) {
    this.name = name;
    this.description = description;
  }
}

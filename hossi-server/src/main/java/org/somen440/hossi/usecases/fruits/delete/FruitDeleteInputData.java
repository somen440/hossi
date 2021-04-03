package org.somen440.hossi.usecases.fruits.delete;

import org.somen440.hossi.usecases.InputData;

public class FruitDeleteInputData implements InputData<FruitDeleteOutputData> {

  public String id;

  public FruitDeleteInputData() {}

  public FruitDeleteInputData(String id) {
    this.id = id;
  }
}

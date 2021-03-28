package org.somen440.hossi.usecases.fruits.add;

import org.somen440.hossi.usecases.fruits.FruitData;
import org.somen440.hossi.usecases.OutputData;

public class FruitAddOutputData implements OutputData {

  public FruitData fruit;

  public FruitAddOutputData() {}

  public FruitAddOutputData(FruitData fruit) {
    this.fruit = fruit;
  }
}

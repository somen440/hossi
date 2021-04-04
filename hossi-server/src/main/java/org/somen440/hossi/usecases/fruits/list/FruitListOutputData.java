package org.somen440.hossi.usecases.fruits.list;

import java.util.Set;
import org.somen440.hossi.usecases.OutputData;
import org.somen440.hossi.usecases.fruits.FruitData;

public class FruitListOutputData implements OutputData {

  public Set<FruitData> fruits;

  public FruitListOutputData() {}

  public FruitListOutputData(Set<FruitData> fruits) {
    this.fruits = fruits;
  }
}

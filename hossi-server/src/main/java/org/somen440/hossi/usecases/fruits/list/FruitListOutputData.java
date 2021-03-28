package org.somen440.hossi.usecases.fruits.list;

import org.somen440.hossi.usecases.OutputData;
import org.somen440.hossi.usecases.fruits.FruitData;

import java.util.Set;

public class FruitListOutputData implements OutputData {

    public Set<FruitData> fruits;

    public FruitListOutputData() {
    }

    public FruitListOutputData(Set<FruitData> fruits) {
        this.fruits = fruits;
    }
}

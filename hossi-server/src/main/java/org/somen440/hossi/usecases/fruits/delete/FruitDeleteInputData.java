package org.somen440.hossi.usecases.fruits.delete;

import org.somen440.hossi.usecases.InputData;

public class FruitDeleteInputData implements InputData<FruitDeleteOutputData> {

    public int id;

    public FruitDeleteInputData() {
    }

    public FruitDeleteInputData(int id) {
        this.id = id;
    }
}
